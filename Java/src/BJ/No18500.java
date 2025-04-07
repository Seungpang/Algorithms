package BJ;
// 미네랄 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No18500 {

    static int R, C, N;
    static char[][] cave;
    static int[] rods;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        cave = new char[R][C];

        for (int i = 0; i < R; i++) {
            cave[i] = br.readLine().toCharArray();
        }

        N = Integer.parseInt(br.readLine());
        rods = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            rods[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int height = R - rods[i];
            if (i % 2 == 0) {
                for (int j = 0; j < C; j++) {
                    if (cave[height][j] == 'x') {
                        cave[height][j] = '.';
                        break;
                    }
                }
            } else {
                for (int j = C - 1; j >= 0; j--) {
                    if (cave[height][j] == 'x') {
                        cave[height][j] = '.';
                        break;
                    }
                }
            }
            visited = new boolean[R][C];
            for (int j = 0; j < C; j++) {
                if (cave[R-1][j] == 'x' && !visited[R-1][j]) {
                    dfs(R-1, j);
                }
            }

            fall();
        }

        StringBuilder sb = new StringBuilder();
        for (char[] row : cave) {
            sb.append(new String(row)).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int row, int col) {
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];
            if (isValid(newRow, newCol) && cave[newRow][newCol] == 'x' && !visited[newRow][newCol]) {
                dfs(newRow, newCol);
            }
        }
    }

    static boolean isValid(int row, int col) {
        return row >= 0 && row < R && col >= 0 && col < C;
    }

    static void fall() {
        List<Integer> cluster = new ArrayList<>();
        for (int i = R - 2; i >= 0; i--) {
            for (int j = 0; j < C; j++) {
                if (cave[i][j] == 'x' && !visited[i][j]) {
                    cave[i][j] = '.';
                    cluster.add(i * C + j);
                }
            }
        }

        int drop = R-1;
        for (int cell : cluster) {
            int row = cell / C;
            int col = cell % C;

            int fallDist = 0;
            while (row + fallDist + 1 < R && cave[row + fallDist + 1][col] == '.') {
                fallDist++;
            }
            drop = Math.min(drop, fallDist);
        }

        for (int cell : cluster) {
            int row = cell / C;
            int col = cell % C;
            cave[row + drop][col] = 'x';
        }
    }
}
