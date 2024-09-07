package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No1799 {

    static int n;
    static int[][] board;
    static List<int[]>[] positions;
    static boolean[] diag1, diag2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        positions = new List[2];
        positions[0] = new ArrayList<>();
        positions[1] = new ArrayList<>();
        diag1 = new boolean[2*n];
        diag2 = new boolean[2*n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    positions[(i+j) % 2].add(new int[]{i, j});
                }
            }
        }

        int result = dfs(0, 0, 0) + dfs(0, 0, 1);
        System.out.println(result);
    }

    static int dfs(int index, int count, int color) {
        if (index == positions[color].size()) {
            return count;
        }

        int result = 0;
        int[] pos = positions[color].get(index);
        int row = pos[0], col = pos[1];

        if (!diag1[row+col] && !diag2[row-col+n]) {
            diag1[row+col] = diag2[row-col+n] = true;
            result = dfs(index + 1, count + 1, color);
            diag1[row+col] = diag2[row-col+n] = false;
        }

        return Math.max(result, dfs(index + 1, count, color));
    }
}
