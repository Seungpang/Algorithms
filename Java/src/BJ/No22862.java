package BJ;
// 가장 긴 짝수 연속한 부분 수열 (large)

import java.util.Scanner;

public class No22862 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int start = 0;
        int end = 0;
        int count = 0;
        int result = 0;

        while (end < n) {
            if (count < k || a[end] % 2 == 0) {
                if (a[end] % 2 != 0) {
                    count++;
                }
                end++;
                result = Math.max(end - start - count, result);
            } else {
                if (a[start] % 2 != 0) {
                    count--;
                }
                start++;
            }
        }
        System.out.println(result);
    }
}
