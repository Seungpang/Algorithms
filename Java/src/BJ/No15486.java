package BJ;
// 퇴사2
import java.util.Arrays;
import java.util.Scanner;

public class No15486 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] dp = new long[1500005];
        int n = sc.nextInt();
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        for (int i = n; i >= 1; i--) {
            if (i + t[i] <= n + 1) {
                dp[i] = Math.max(dp[i + t[i]] + p[i], dp[i + 1]);
            } else {
                dp[i] = dp[i + 1];
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsLong());
    }
}
