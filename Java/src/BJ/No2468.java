package BJ;
// 안전 영역

import java.util.Scanner;

public class No2468 {

    static int n;
    static boolean[][][] visited;
    static int[][] a;
    static int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n][n][100];
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int result = 1;
        for (int k = 1; k < 100; k++) {
            int count = 0;
            visited = new boolean[n][n][100];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j][k] && a[i][j] > k) {
                        dfs(i, j, k);
                        count++;
                    }
                }
            }
            result = Math.max(result, count);
        }
        System.out.println(result);
    }

    public static void dfs(int i, int j, int precipitation) {
        if (a[i][j] < precipitation) {
            return;
        }
        visited[i][j][precipitation] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < n && x >= 0 && y < n && y >= 0 && !visited[x][y][precipitation] && a[x][y] > precipitation) {
                visited[x][y][precipitation] = true;
                dfs(x, y, precipitation);
            }
        }
    }
}
