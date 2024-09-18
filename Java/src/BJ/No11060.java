package BJ;
// 점프 점프
import java.util.Arrays;
import java.util.Scanner;

public class No11060 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] mazes = new int[N];
        for (int i = 0; i < N; i++) {
            mazes[i] = sc.nextInt();
        }

        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }

            for (int j = 1; j <= mazes[i] && i + j < N; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }

        System.out.println(dp[N - 1] == Integer.MAX_VALUE ? -1 : dp[N - 1]);
    }
}
