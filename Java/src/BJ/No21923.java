package BJ;
// 곡예 비행

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No21923 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dpUp = new int[n][m];
        int[][] dpDown = new int[n][m];
        dpUp[n - 1][0] = map[n - 1][0];
        for (int i = n - 1; i >= 0; i--) {
            if (i != n - 1) {
                dpUp[i][0] = dpUp[i + 1][0] + map[i][0];
            }
            for (int j = 1; j < m; j++) {
                if (i != n - 1) {
                    dpUp[i][j] = Math.max(dpUp[i + 1][j], dpUp[i][j - 1]) + map[i][j];
                } else {
                    dpUp[i][j] = dpUp[i][j - 1] + map[i][j];
                }
            }
        }

        dpDown[n - 1][m - 1] = map[n - 1][m - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (i != n - 1) {
                dpDown[i][m - 1] = dpDown[i + 1][m - 1] + map[i][m - 1];
            }
            for (int j = m - 2; j >= 0; j--) {
                if (i != n - 1) {
                    dpDown[i][j] = Math.max(dpDown[i + 1][j], dpDown[i][j + 1]) + map[i][j];
                } else {
                    dpDown[i][j] = dpDown[i][j + 1] + map[i][j];
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(dpUp[i][j] + dpDown[i][j], max);
            }
        }
        System.out.println(max);
    }
}
