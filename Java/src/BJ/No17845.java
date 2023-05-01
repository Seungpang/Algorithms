package BJ;
// 수강 과목

import java.util.Scanner;

public class No17845 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] subjects = new int[k][2];
        for (int i = 0; i < k; i++) {
            subjects[i][0] = sc.nextInt();
            subjects[i][1] = sc.nextInt();
        }

        int[] dp = new int[n + 1];
        for (int i = 0; i < k; i++) {
            for (int j = n; j >=subjects[i][1]; j--) {
                dp[j] = Math.max(dp[j - subjects[i][1]] + subjects[i][0], dp[j]);
            }
        }
        System.out.println(dp[n]);
    }
}
