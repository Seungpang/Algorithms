package Programmers;

public class PG49191 {

    public static void main(String[] args) {
        final PG49191 pg49191 = new PG49191();
        System.out.println(pg49191.solution(5, new int[][]{
                {4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}
        }));
    }

    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] scoreBoard = new int[n + 1][n + 1];
        for (int i = 0; i < results.length; i++) {
            int a = results[i][0];
            int b = results[i][1];
            scoreBoard[a][b] = 1;
            scoreBoard[b][a] = -1;
        }

        for (int i=1; i<=n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (scoreBoard[i][k] == 1 && scoreBoard[k][j] == 1) {
                        scoreBoard[i][j] = 1;
                        scoreBoard[j][i] = -1;
                    }
                    if (scoreBoard[i][k] == -1 && scoreBoard[k][j] == -1) {
                        scoreBoard[i][j] = -1;
                        scoreBoard[i][j] = 1;
                    }
                }
            }
        }

        for (int i=1; i<=n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (scoreBoard[i][j] != 0) {
                    count++;
                }
            }
            if (count == n-1) {
                answer++;
            }
        }
        return answer;
    }
}
