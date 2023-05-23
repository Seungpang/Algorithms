package BJ;
// 알파벳

import java.util.Scanner;

public class No1987 {

    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int r, c, result;
    static char[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = sc.next();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        boolean[] alpha = new boolean[26];
        alpha[map[0][0] - 'A'] = true;
        dfs(0, 0, 1, alpha);
        System.out.println(result);
    }

    static void dfs(int x, int y, int count, boolean[] alpha) {
        result = Math.max(count, result);
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && ny >= 0 && nx < r && ny < c && !alpha[map[nx][ny] - 'A']) {
                alpha[map[nx][ny] - 'A'] = true;
                dfs(nx, ny, count + 1, alpha);
                alpha[map[nx][ny] - 'A'] = false;
            }
        }
    }
}
