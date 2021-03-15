package kakao.blind2020;

public class TaxiFare {
    static final int INF = 20000000;
    int[][] Dist = new int[200][200];

    void floyd(int n) {
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (Dist[i][k] + Dist[k][j] < Dist[i][j]) {
                        Dist[i][j] = Dist[i][k] + Dist[k][j];
                    }
                }
            }
        }
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j)
                    Dist[i][j] = 0;
                else
                    Dist[i][j] = INF;
            }
        }

        for (int[] edge : fares) {
            Dist[edge[0]-1][edge[1]-1] = edge[2];
            Dist[edge[1]-1][edge[0]-1] = edge[2];
        }

        floyd(n);

        --s;
        --a;
        --b;
        int answer = INF;
        for (int k = 0; k < n; ++k) {
            answer = Math.min(answer, Dist[s][k] + Dist[k][a] + Dist[k][b]);
        }

        return answer;
    }

    public static void main(String[] args) {

        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        TaxiFare test = new TaxiFare();
        System.out.println(test.solution(n,s,a,b,fares));
    }
}
