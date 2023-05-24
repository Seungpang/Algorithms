package BJ;
// 조 짜기

import java.util.Scanner;

public class No2229 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int max = 0;
            int min = 10001;
            a[i] = sc.nextInt();

            for (int j = i; j > 0; j--) {
                max = Math.max(max, a[j]);
                min = Math.min(min, a[j]);
                dp[i] = Math.max(dp[i], max - min + dp[j - 1]);
            }
        }
        System.out.println(dp[n]);
    }
}
