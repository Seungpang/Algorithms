package BJ;
// 앱

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No7579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] memory = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        int[] cost = new int[N+1];
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            sum += cost[i];
        }

        int[] dp = new int[sum + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = sum; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
            }
        }

        int ans = sum;
        for (int i = 0; i <= sum; i++) {
            if (dp[i] >= M) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}
