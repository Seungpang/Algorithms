package BJ;
// NxM 보드 완주하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No9944 {

    static int N, M, dotNum, min;
    static char[][] map;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = 1;
        String input = "";
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            dotNum = 0;
            min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                for (int j = 0; j < M; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == '.') {
                        dotNum++;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != '*') {
                        boolean[][] visited = new boolean[N][M];
                        visited[i][j] = true;
                        dfs(i, j, visited, 1, 0);
                        visited[i][j] = false;
                    }
                }
            }

            if (min == Integer.MAX_VALUE) {
                System.out.println("Case " + t + ": -1");
            } else {
                System.out.println("Case " + t + ": " + min);
            }
            t++;
        }
    }

    static void dfs(int row, int col, boolean[][] visited, int dot, int route) {
        if (dot == dotNum) {
            min = Math.min(route, min);
            return;
        }
        for (int[] dir : dirs) {
            int count = 0;
            int copyRow = row;
            int copyCol = col;

            while (true) {
                int nr = copyRow + dir[0];
                int nc = copyCol + dir[1];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == '*') {
                    break;
                }
                copyRow = nr;
                copyCol = nc;
                visited[nr][nc] = true;
                count++;
            }

            if (row != copyRow  ||col != copyCol) {
                dfs(copyRow, copyCol, visited, dot + count, route + 1);

                // 왔던길 다시 원래대로
                for (int d = 1; d <= count; d++) {
                    int y = row + dir[0] * d;
                    int x = col + dir[1] * d;
                    visited[y][x] = false;
                }
            }
        }
    }
}
