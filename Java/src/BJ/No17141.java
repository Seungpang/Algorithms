package BJ;
// 연구소 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class No17141 {

    static int N, M, result = Integer.MAX_VALUE;
    static int[][] map, copy;
    static List<Point> virus = new ArrayList<>();
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        copy = new int[N][N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    count++;
                }
                if (map[i][j] == 2) {
                    virus.add(new Point(i, j));
                    map[i][j] = 0;
                }
            }
        }

        dfs(0, 0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    static void dfs(int idx, int cnt) {
        if (cnt == M) {
            bfs();
            return;
        }

        for (int i = idx; i < virus.size(); i++) {
            Point point = virus.get(i);
            map[point.x][point.y] = 2;
            dfs(i + 1, cnt + 1);
            map[point.x][point.y] = 0;
        }
    }

    static void bfs() {
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
            for (int j = 0; j < N; j++) {
                if (copy[i][j] == 2) {
                    q.add(new Point(i, j));
                }
            }
        }

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point point = q.poll();
                for (int[] dir : dirs) {
                    int nx = point.x + dir[0];
                    int ny = point.y + dir[1];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if (copy[nx][ny] != 0) continue;

                    copy[nx][ny] = 2;
                    q.add(new Point(nx, ny));
                }
            }

            time++;
        }

        if (check()) result = Math.min(result, time - 1);
    }

    static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (copy[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static class Point {
        int x, y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }
}
