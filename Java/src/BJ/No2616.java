package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2616 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] passengers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            passengers[i] = Integer.parseInt(st.nextToken());
        }

        int maxActive = Integer.parseInt(br.readLine());

        int[] windowSum = new int[n + 1];
        int currSum = 0;
        for (int i = 0; i < n; i++) {
            currSum += passengers[i];
            if (i >= maxActive - 1) {
                windowSum[i + 1] = currSum;
                currSum -= passengers[i - maxActive + 1];
            }
        }

        int[][] dp = new int[4][n + 1];
        for (int i = 1; i <= 3; i++) {
            for (int j = maxActive; j <= n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - maxActive] + windowSum[j]);
            }
        }

        System.out.println(dp[3][n]);
    }
}
