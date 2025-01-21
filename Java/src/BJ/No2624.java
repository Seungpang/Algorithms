package BJ;
// 동전 바꿔주기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2624 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        int k = Integer.parseInt(br.readLine().trim());

        int[] coinValues = new int[k+1];
        int[] coinCounts = new int[k+1];

        for (int i = 1; i <= k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coinValues[i] = Integer.parseInt(st.nextToken());
            coinCounts[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[k + 1][T + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j <= T; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int l = 1; l <= coinCounts[i]; l++) {
                    if (j >= l * coinValues[i]) {
                        dp[i][j] += dp[i - 1][j - l * coinValues[i]];
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(dp[k][T]);
    }
}
