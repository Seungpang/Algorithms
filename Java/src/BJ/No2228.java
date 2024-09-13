package BJ;
// 구간 나누기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2228 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[M + 1][N + 1];
        int[] sum = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            sum[i] = Integer.parseInt(br.readLine()) + sum[i - 1];
        }

        for (int i = 0; i <= M; i++) {
            Arrays.fill(dp[i], -32769 * 100);
        }
        for (int j = 0; j <= N; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i][j - 1];

                for (int k = 1; k <= j; k++) {
                    if (k >= 2) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k - 2] + sum[j] - sum[k - 1]);
                    } else if (k == 1 && i == 1) {
                        dp[i][j] = Math.max(dp[i][j], sum[j]);
                    }
                }
            }
        }

        System.out.println(dp[M][N]);
    }
}
