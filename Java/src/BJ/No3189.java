package BJ;
// 양치기 꿍

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No3189 {
    static boolean[][] visited;
    static char[][] map;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int R, C,v, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
             }
        }

        visited = new boolean[R][C];
        int[] ans = new int[2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && map[i][j] != '#') {
                    int[] result = bfs(i, j);
                    ans[0] += result[0];
                    ans[1] += result[1];
                }
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
    }

    static int[] bfs(int x, int y) {
        v = 0;
        k = 0;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        countAnimal(x, y);
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int[] dir : dirs) {
                int nx = now.x + dir[0];
                int ny = now.y + dir[1];
                if (nx >= 0 && ny >= 0 && nx < R && ny < C && map[nx][ny] != '#' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    countAnimal(nx, ny);
                    q.offer(new Point(nx, ny));
                }
            }
        }
        if (k > v) {
            return new int[]{k, 0};
        }
        return new int[]{0, v};
    }

    static void countAnimal(int x, int y) {
        if (map[x][y] == 'v') {
            v++;
        } else if (map[x][y] == 'k') {
            k++;
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
