package BJ;
// 토마토

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No7569 {

    static boolean[][][] visited;
    static Queue<Point> q;
    static int[][][] a;
    static int m, n, h;
    static int[][] dirs = {{0, 1, 0}, {0, -1, 0}, {-1, 0, 0}, {1, 0, 0}, {0, 0, 1}, {0, 0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();
        a = new int[h][n][m];
        visited = new boolean[h][n][m];

        q = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    a[i][j][k] = sc.nextInt();
                    if (a[i][j][k] == 1) {
                        q.add(new Point(i, j, k));
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    static class Point {
        int height;
        int row;
        int col;

        public Point(final int height, final int row, final int col) {
            this.height = height;
            this.row = row;
            this.col = col;
        }
    }

    public static int bfs() {
        while (!q.isEmpty()) {
            Point nowPoint = q.poll();
            int height = nowPoint.height;
            int row = nowPoint.row;
            int col = nowPoint.col;
            for (int[] dir : dirs) {
                int nHeight = dir[2] + height;
                int nRow = dir[0] + row;
                int nCol = dir[1] + col;
                if (nHeight < h && nHeight >= 0 && nRow < n && nRow >= 0 && nCol < m && nCol >= 0
                        && a[nHeight][nRow][nCol] == 0) {
                    q.add(new Point(nHeight, nRow, nCol));
                    a[nHeight][nRow][nCol] = a[height][row][col] + 1;
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (a[i][j][k] == 0) return -1;
                    result = Math.max(result, a[i][j][k]);
                }
            }
        }

        if (result == 1) {
            return 0;
        } else {
            return result - 1;
        }
    }
}
