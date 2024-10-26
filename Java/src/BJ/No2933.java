package BJ;
// 미네랄

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2933 {

    static int R, C, N;
    static char[][] map;
    static int[] heights;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            map[i] = s.toCharArray();
        }

        N = Integer.parseInt(br.readLine());
        heights = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int height = R - heights[i];
            if (i % 2 == 0) {
                throwStickLeft(height);
            } else {
                throwStickRight(height);
            }
            checkCluster();
        }

        printMap();
    }

    static void throwStickLeft(int height) {
        for (int i = 0; i < C; i++) {
            if (map[height][i] == 'x') {
                map[height][i] = '.';
                break;
            }
        }
    }

    static void throwStickRight(int height) {
        for (int i = C - 1; i >= 0; i--) {
            if (map[height][i] == 'x') {
                map[height][i] = '.';
                break;
            }
        }
    }

    static void checkCluster() {
        visited = new boolean[R][C];
        for (int i = 0; i < C; i++) {
            if (map[R - 1][i] == 'x' && !visited[R - 1][i]) {
                bfs(R - 1, i);
            }
        }

        List<Point> cluster = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'x' && !visited[i][j]) {
                    cluster.add(new Point(i, j));
                    map[i][j] = '.';
                }
            }
        }

        if (cluster.isEmpty()) {
            return;
        }

        int dropHeight = Integer.MAX_VALUE;
        for (Point p : cluster) {
            int x = p.x;
            int y = p.y;
            int dist = 0;

            while (true) {
                x++;
                if (x >= R) {
                    break;
                }
                if (map[x][y] == 'x') {
                    break;
                }
                dist++;
            }
            dropHeight = Math.min(dropHeight, dist);
        }

        for (Point p : cluster) {
            map[p.x + dropHeight][p.y] = 'x';
        }
    }

    static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    continue;
                }
                if (!visited[nx][ny] && map[nx][ny] == 'x') {
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }
            }
        }
    }

    static void printMap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
