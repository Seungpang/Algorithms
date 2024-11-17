package BJ;
// 1, 2, 3 더하기 9

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16195 {

    static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int maxN = 1000;
        int[][] dp = new int[maxN + 1][maxN + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= maxN; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MOD;
                if (i >= 2) dp[i][j] = (dp[i][j] + dp[i - 2][j - 1]) % MOD;
                if (i >= 3) dp[i][j] = (dp[i][j] + dp[i - 3][j - 1]) % MOD;
            }
        }

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int result = 0;
            for (int j = 1; j <= m; j++) {
                result = (result + dp[n][j]) % MOD;
            }
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
