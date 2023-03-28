package BJ;
// 감시

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No15683 {
    static int n, m;
    static List<Point> cctv = new ArrayList<>();
    static int[][] map1;
    static int[][] map2;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int min = 0;
        map1 = new int[n][m];
        map2 = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map1[i][j] = sc.nextInt();
                if (map1[i][j] != 0 && map1[i][j] != 6) {
                    cctv.add(new Point(i, j));
                }
                if (map1[i][j] == 0) {
                    min++;
                }
            }
        }

        for (int tmp = 0; tmp < (1 << (2 * cctv.size())); tmp++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map2[i][j] = map1[i][j];
                }
            }

            int brute = tmp;
            for (int i = 0; i < cctv.size(); i++) {
                int dir = brute % 4;
                brute /= 4;
                int x = cctv.get(i).x;
                int y = cctv.get(i).y;
                if (map1[x][y] == 1) {
                    dfs(x, y, dir);
                } else if (map1[x][y] == 2) {
                    dfs(x, y, dir);
                    dfs(x, y, dir + 2);
                } else if (map1[x][y] == 3) {
                    dfs(x, y, dir);
                    dfs(x, y, dir + 1);
                } else if (map1[x][y] == 4) {
                    dfs(x, y, dir);
                    dfs(x, y, dir + 1);
                    dfs(x, y, dir + 2);
                } else {
                    dfs(x, y, dir);
                    dfs(x, y, dir + 1);
                    dfs(x, y, dir + 2);
                    dfs(x, y, dir + 3);
                }
            }
            int val = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map2[i][j] == 0) {
                        val++;
                    }
                }
            }
            min = Math.min(min, val);
        }
        System.out.println(min);
    }

    public static void dfs(int x, int y, int dir) {
        dir %= 4;
        while (true) {
            x += dirs[dir][0];
            y += dirs[dir][1];
            if (x < 0 || y < 0 || x >= n || y >= m || map2[x][y] == 6) {
                return;
            }
            if (map2[x][y] != 0) {
                continue;
            }
            map2[x][y] = 7;
        }
    }
    static class Point {
        int x, y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }
}
