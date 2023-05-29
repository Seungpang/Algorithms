package BJ;
// 수들의 합 5

import java.util.Scanner;

public class No2018 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[10000001];
        for (int i = 1; i <= 10000000; i++) {
            a[i] = i;
        }

        int left = 1;
        int right = 1;
        int result = 0;
        while (left <= right) {
            long sum = 0;
            for (int i = left; i <= right; i++) {
                sum += a[i];
            }
            if (sum < n) {
                right++;
            } else if (sum > n) {
                left++;
            } else {
                result++;
                left++;
            }
        }
        System.out.println(result);
    }
}
