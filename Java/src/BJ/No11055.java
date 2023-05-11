package BJ;
//다이내믹 프로그래밍
//가장 큰 증가하는 부분 수열

import java.util.Arrays;
import java.util.Scanner;

public class No11055 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        int[] dp = new int[n+1];
        for (int i=1; i<=n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i=1; i<=n; i++) {
            dp[i] = a[i];
            for (int j=0; j<i; j++) {
                if (a[j] < a[i] && dp[i] < dp[j] + a[i]) {
                    dp[i] = dp[j] + a[i];
                }
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
