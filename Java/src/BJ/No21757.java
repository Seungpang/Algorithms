package BJ;
// 나누기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No21757 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        long[] prefixSum = new long[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }

        long totalSum = prefixSum[N];
        if (totalSum % 4 != 0) {
            System.out.println(0);
            return;
        }

        long targetSum = totalSum / 4;
        long[][] dp = new long[N + 1][4];

        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 3; j++) {
                dp[i][j] = dp[i - 1][j];
                if (prefixSum[i] == targetSum * j) {
                    dp[i][j] += dp[i-1][j - 1];
                }
            }
        }

        System.out.println(dp[N-1][3]);
    }
}
