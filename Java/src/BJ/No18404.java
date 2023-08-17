package BJ;
// 현명한 나이트

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No18404 {
    static int[][] dirs = {
            {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}
    };
    static int knightX, knightY, N;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];

        st = new StringTokenizer(br.readLine());
        knightX = Integer.parseInt(st.nextToken());
        knightY = Integer.parseInt(st.nextToken());

        bfs();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            System.out.print(map[x][y] - 1 + " ");
        }
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{knightX, knightY});
        map[knightX][knightY] = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx > N || ny < 0 || ny > N || map[nx][ny] != 0) {
                    continue;
                }
                map[nx][ny] = map[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}
