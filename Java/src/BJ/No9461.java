package BJ;
// 파도반 수열
import java.util.Scanner;

public class No9461 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long[] dp = new long[105];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        for (int i = 5; i <= 100; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
