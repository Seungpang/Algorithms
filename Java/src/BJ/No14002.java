package BJ;
//다이내믹 프로그래밍
//가장 긴 증가하는 부분 수열 4

import java.util.Scanner;

public class No14002 {

    static int[] dp;
    static int[] visited;
    static int[] a;
    static void go(int p) {
        if (p==-1) return;
        go(visited[p]);
        System.out.print(a[p] + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n];
        visited = new int[n];
        a = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i=0; i<n; i++) {
            dp[i] = 1;
            visited[i] = -1;
            for (int j=0; j<i; j++) {
                if (a[j] < a[i] && dp[i] < dp[j] +1) {
                    dp[i] = dp[j] + 1;
                    visited[i] = j;
                }
            }
        }

        int result = dp[0];
        int p = 0;
        for (int i=0; i<n; i++) {
            if (result < dp[i]) {
                result = dp[i];
                p = i;
            }
        }
        System.out.println(result);
        go(p);
        System.out.println();
    }
}
