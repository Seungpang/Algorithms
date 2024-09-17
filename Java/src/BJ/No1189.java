package BJ;
// 컴백홈

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1189 {

    static int R, C, K, count;
    static char[][] map;
    static boolean[][] visited;
    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        visited[R - 1][0] = true;
        dfs(R-1, 0, 1);

        System.out.println(count);
    }

    static void dfs(int r, int c, int dist) {
        if (r == 0 && c == C-1) {
            if (dist == K) {
                count++;
            }
            return;
        }

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc] || map[nr][nc] == 'T') {
                continue;
            }

            visited[nr][nc] = true;
            dfs(nr, nc, dist + 1);
            visited[nr][nc] = false;
        }
    }
}
