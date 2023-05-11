package BJ;
// 꿀 따기

import java.util.Scanner;

public class No21758 {
    static int[] a = new int[100001];
    static int[] sum = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            sum[i] = a[i] + sum[i - 1];
        }

        long answer = 0;
        for (int i = 2; i < n; i++) {
            answer = Math.max(answer, sum[n] - a[1] - a[i] + sum[n] - sum[i]);
        }
        for (int i = 2; i < n; i++) {
            answer = Math.max(answer, sum[n] - a[n] - a[i] + sum[i - 1]);
        }
        for (int i = 2; i < n; i++) {
            answer = Math.max(answer, sum[i] - a[1] + sum[n] - sum[i - 1] - a[n]);
        }
        System.out.println(answer);
    }
}
