package BJ;
// 일루미네이션

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No5547 {

    static int[][] evenDirs = {{-1, 0}, {1, 0}, {-1, -1}, {0, -1}, {-1, 1}, {0, 1}};
    static int[][] oddDirs = {{-1, 0}, {1, 0}, {0, -1}, {1, -1}, {0, 1}, {1, 1}};
    static int W, H;
    static int[][] map;
    static boolean[][] outside;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        outside = new boolean[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        int result = 0;
        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                if (map[y][x] == 1) {
                    boolean isOddRow = (y % 2 == 0);
                    int[][] dirs = isOddRow ? oddDirs : evenDirs;

                    for (int[] d : dirs) {
                        int nx = x + d[0];
                        int ny = y + d[1];
                        if (!inRange(nx, ny) || outside[ny][nx]) {
                            result++;
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        for (int x = 0; x < W; x++) {
            if (map[0][x] == 0) {
                q.offer(new int[]{x, 0});
                outside[0][x] = true;
            }
            if (map[H - 1][x] == 0) {
                q.offer(new int[]{x, H - 1});
                outside[H - 1][x] = true;
            }
        }
        for (int y = 0; y < H; y++) {
            if (map[y][0] == 0) {
                q.offer(new int[]{0, y});
                outside[y][0] = true;
            }
            if (map[y][W - 1] == 0) {
                q.offer(new int[]{W - 1, y});
                outside[y][W - 1] = true;
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            boolean isOddRow = (cy % 2 == 0);
            int[][] dirs = isOddRow ? oddDirs : evenDirs;

            for (int[] d : dirs) {
                int nx = cx + d[0];
                int ny = cy + d[1];
                if (inRange(nx, ny) && !outside[ny][nx] && map[ny][nx] == 0) {
                    outside[ny][nx] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < W && y >= 0 && y < H;
    }
}
