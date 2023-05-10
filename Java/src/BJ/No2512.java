package BJ;
// 예산

import java.util.Scanner;

public class No2512 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            right = Math.max(right, a[i]);
        }
        int target = sc.nextInt();
        while (left <= right) {
            int mid = (left + right) / 2;
            long total = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] > mid) {
                    total += mid;
                } else {
                    total += a[i];
                }
            }
            if (total <= target) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        System.out.println(right);
    }
}
