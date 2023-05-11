package BJ;
//이분 탐색
//나무 자르기

import java.util.Scanner;

public class No2805 {
    static boolean check(long[] a, long m, long x) {
        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] - x > 0) {
                sum += a[i] - x;
            }
        }
        return sum >= m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] a = new long[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
            max = Math.max(max, a[i]);
        }

        long left = 0;
        long right = max;
        long ans = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (check(a, m, mid)) {
                ans = Math.max(mid, ans);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
