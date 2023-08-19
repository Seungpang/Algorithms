package BJ;
// RGB 거리 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No17404 {

    static final int INF = 1000 * 1000 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N + 1][3];
        int answer = INF;
        for (int k = 0; k < 3; k++) {
            for (int j = 0; j < 3; j++) {
                if (j == k) {
                    dp[1][j] = cost[1][j];
                } else {
                    dp[1][j] = INF;
                }
            }
            System.out.println(Arrays.deepToString(dp));
            for (int i = 2; i <= N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
                dp[i][1] = Math.min(dp[i - 1][2], dp[i - 1][0]) + cost[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
            }

            for (int j = 0; j < 3; j++) {
                if (j == k) continue;
                answer = Math.min(answer, dp[N][j]);
            }
        }

        System.out.println(answer);
    }
}
