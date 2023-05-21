package BJ;
// 두 개의 탑

import java.util.Scanner;

public class No2118 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt() + a[i - 1];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int right = a[j - 1] - a[i - 1];
                int left = a[n] - right;
                int result = Math.min(right, left);
                max = Math.max(result, max);
                if (right >= left) {
                    break;
                }
            }
        }
        System.out.println(max);
    }
}
