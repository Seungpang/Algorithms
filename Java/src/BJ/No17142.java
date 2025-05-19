package BJ;
// 연구소 3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class No17142 {

    static int N, M, result = Integer.MAX_VALUE;
    static int[][] map;
    static List<Point> virus = new ArrayList<>();
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int totalBlank = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virus.add(new Point(i, j));
                } else if (map[i][j] == 0) {
                    totalBlank++;
                }
            }
        }

        dfs(0, 0, new Point[M]);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    static void dfs(int start, int depth, Point[] selected) {
        if (depth == M) {
            bfs(selected);
            return;
        }

        for (int i = start; i < virus.size(); i++) {
            selected[depth] = virus.get(i);
            dfs(i + 1, depth + 1, selected);
        }
    }

    static void bfs(Point[] activeVirus) {
        Queue<Point> q = new LinkedList<>();
        int[][] time = new int[N][N];
        for (int[] row : time) Arrays.fill(row, -1);

        for (Point p : activeVirus) {
            q.add(p);
            time[p.x][p.y] = 0;
        }

        int spread = 0;
        int maxTime = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int[] dir : dirs) {
                int nx = cur.x + dir[0];
                int ny = cur.y + dir[1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (map[nx][ny] == 1 || time[nx][ny] != -1) continue;

                time[nx][ny] = time[cur.x][cur.y] + 1;
                q.add(new Point(nx, ny));

                if (map[nx][ny] == 0) {
                    spread++;
                    maxTime = time[nx][ny];
                }
            }
        }

        if (spread == totalBlank) {
            result = Math.min(result, maxTime);
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
