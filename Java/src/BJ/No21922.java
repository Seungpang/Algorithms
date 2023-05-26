package BJ;
// 	학부 연구생 민상

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No21922 {

    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static Queue<Point> q = new LinkedList<>();
    static boolean[][][] visited;
    static int[][] map;
    static int r, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        map = new int[r][c];
        visited = new boolean[r][c][4];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 9) {
                    for (int dir = 0; dir < 4; dir++) {
                        q.add(new Point(i, j, dir));
                        visited[i][j][dir] = true;
                    }
                }
            }
        }

        bfs();

        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int dir = 0; dir < 4; dir++) {
                    if (visited[i][j][dir]) {
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Point now = q.poll();
            int nx = now.x + dirs[now.d][0];
            int ny = now.y + dirs[now.d][1];
            if (nx >= 0 && ny >= 0 && nx < r && ny < c && !visited[nx][ny][now.d]) {
                visited[nx][ny][now.d] = true;
                switch (map[nx][ny]) {
                    case 1:
                        now.d = now.d % 2 == 0 ? now.d : ((now.d + 2) % 4);
                        break;
                    case 2:
                        now.d = now.d % 2 == 1 ? now.d : ((now.d + 2) % 4);
                        break;
                    case 3:
                        if (now.d == 0) {
                            now.d = 1;
                        } else if (now.d == 1) {
                            now.d = 0;
                        } else if (now.d == 2) {
                            now.d = 3;
                        } else if (now.d == 3) {
                            now.d = 2;
                        }
                        break;
                    case 4:
                        if (now.d == 0) {
                            now.d = 3;
                        } else if (now.d == 1) {
                            now.d = 2;
                        } else if (now.d == 2) {
                            now.d = 1;
                        } else if (now.d == 3) {
                            now.d = 0;
                        }
                        break;
                }
                q.offer(new Point(nx, ny, now.d));
            }
        }
    }

    static class Point {
        int x, y, d;

        public Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
