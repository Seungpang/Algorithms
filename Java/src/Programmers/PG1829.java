package Programmers;

import java.util.Arrays;

public class PG1829 {
    int count;
    int numberOfArea;
    int maxSizeOfOneArea;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    boolean[][] visited;

    public static void main(String[] args) {
        final PG1829 pg1829 = new PG1829();
        System.out.println(Arrays.toString(pg1829.solution(6, 4, new int[][]{
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        })));
    }

    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        int[] answer = new int[2];

        count = 0;
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    numberOfArea++;
                    dfs(i, j, picture);
                }

                if (count > maxSizeOfOneArea) {
                    maxSizeOfOneArea = count;
                }
                count = 0;
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private void dfs(int x, int y, int[][] picture) {
        if (visited[x][y]) return;

        visited[x][y] = true;
        count++;

        for (int[] dir : dirs) {
            int dx = x + dir[0];
            int dy = y + dir[1];

            if (dx < 0 || dx >= picture.length || dy < 0 || dy >= picture[0].length) continue;

            if (picture[x][y] == picture[dx][dy] && !visited[dx][dy]) {
                dfs(dx, dy, picture);
            }
        }
    }
}
