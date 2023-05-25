package BJ;
// 용액

import java.util.Scanner;

public class No2467 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int left = 0;
        int right = a.length - 1;
        int minLeft = 0;
        int minRight = 0;
        long min = Long.MAX_VALUE;
        while (left < right) {
            long sum = a[left] + a[right];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                minLeft = left;
                minRight = right;
            }
            if (sum >= 0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(a[minLeft] + " " + a[minRight]);
    }
}
