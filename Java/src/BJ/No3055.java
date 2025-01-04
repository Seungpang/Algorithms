package BJ;
// 탈출

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No3055 {

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        char[][] map = new char[R][C];

        Point end = null;
        Queue<Point> q = new LinkedList<>();
        Queue<Point> waters = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String s = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'S') {
                    q.offer(new Point(i, j, 0));
                    visited[i][j] = true;
                } else if (map[i][j] == 'D') {
                    end = new Point(i, j, 0);
                } else if (map[i][j] == '*') {
                    waters.offer(new Point(i, j, 0));
                }
            }
        }

        while (!q.isEmpty()) {
            int waterSize = waters.size();
            for (int i = 0; i < waterSize; i++) {
                Point w = waters.poll();
                for (int[] dir : dirs) {
                    int nx = w.row + dir[0];
                    int ny = w.col + dir[1];
                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        waters.offer(new Point(nx, ny, 0));
                    }
                }
            }

            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Point p = q.poll();
                for (int[] dir : dirs) {
                    int nx = p.row + dir[0];
                    int ny = p.col + dir[1];
                    if (nx == end.row && ny == end.col) {
                        System.out.println(p.count + 1);
                        return;
                    }
                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == '.' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new Point(nx, ny, p.count + 1));
                    }
                }
            }
        }

        System.out.println("KAKTUS");
    }

    static class Point {
        int row, col, count;

        public Point(final int row, final int col, final int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
}
