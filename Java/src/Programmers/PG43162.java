package Programmers;
//깊이/너비 우선 탐색(DFS/BFS)
//네트워크


public class PG43162 {

    public static void main(String[] args) {
        PG43162 a = new PG43162();
        System.out.println(a.solution(3,new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(a.solution(3, new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                dfs(computers, i, check);
                answer++;
            }
        }
        return answer;
    }

    private boolean[] dfs(int[][] computers, int i, boolean[] check) {
        check[i] = true;

        for (int j = 0; j < computers.length; j++) {
            if (i != j && computers[i][j] == 1 && !check[j]) {
                check = dfs(computers, j, check);
            }
        }
        return check;
    }
}
