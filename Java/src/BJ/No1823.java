package BJ;
// 수확

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1823 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] v = new int[N+1];

        for (int i = 1; i <= N; i++) {
            v[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            dp[i][i] = v[i] * N;
        }

        for (int len = 2; len <= N; len++) {
            for (int i = 1; i <= N - len + 1; i++) {
                int j = i + len - 1;
                int order = N - (j - i);
                dp[i][j] = Math.max(dp[i+1][j] + v[i] * order,
                        dp[i][j-1] + v[j] * order);
            }
        }

        System.out.println(dp[1][N]);
    }
}
