package BJ;
// 안녕

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1535 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] health = new int[N];
        int[] happy = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            health[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            happy[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][101];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 100; j++) {
                if (health[i - 1] < j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i-1][j - health[i - 1]] + happy[i-1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N][100]);
    }
}
