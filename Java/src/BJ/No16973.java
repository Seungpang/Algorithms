package BJ;
// 직사각형 탈출

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No16973 {

    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int H, W, N, M;
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] canPlace;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        canPlace = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        int Sr = Integer.parseInt(st.nextToken()) - 1;
        int Sc = Integer.parseInt(st.nextToken()) - 1;
        int Fr = Integer.parseInt(st.nextToken()) - 1;
        int Fc = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i <= N - H; i++) {
            for (int j = 0; j <= M - W; j++) {
                canPlace[i][j] = isPossible(i, j);
            }
        }

        System.out.println(bfs(Sr, Sc, Fr, Fc));
    }

    static boolean isPossible(int x, int y) {
        for (int i = x; i < x + H; i++) {
            for (int j = y; j < y + W; j++) {
                if (map[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static int bfs(int sr, int sc, int fr, int fc) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(sr, sc, 0));
        visited[sr][sc] = true;
        while (!q.isEmpty()) {
            Point now = q.poll();
            if (now.x == fr && now.y == fc) {
                return now.count;
            }
            for (int[] dir : dirs) {
                int nx = now.x + dir[0];
                int ny = now.y + dir[1];
                if (nx < 0 || nx + H > N  || ny < 0 || ny + W > M || visited[nx][ny]) continue;
                if (!canPlace[nx][ny]) continue;
                visited[nx][ny] = true;
                q.offer(new Point(nx, ny, now.count + 1));
            }
        }

        return -1;
    }

    static class Point {
        int x, y, count;

        public Point(final int x, final int y, final int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
