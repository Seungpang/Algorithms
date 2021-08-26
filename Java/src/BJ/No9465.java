package BJ;
//다이내믹 프로그래밍
//스티커

import java.util.Scanner;

public class No9465 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- >0) {
            int n = sc.nextInt();
            long[][] a = new long[n+1][2];
            long[][] d = new long[n+1][3];
            for (int i =1; i<=n; i++) {
                a[i][0] = sc.nextInt();
            }

            for (int i=1; i<=n; i++) {
                a[i][1] = sc.nextInt();
            }

            for (int i=1; i<=n; i++) {
                d[i][0] = Math.max(d[i - 1][0], Math.max(d[i - 1][1], d[i - 1][2]));
                d[i][1] = Math.max(d[i - 1][0], d[i - 1][2]) + a[i][0];
                d[i][2] = Math.max(d[i - 1][0], d[i - 1][1]) + a[i][1];
            }
            long result = 0;
            result = Math.max(d[n][0], Math.max(d[n][1], d[n][2]));
            System.out.println(result);
        }
    }
}
