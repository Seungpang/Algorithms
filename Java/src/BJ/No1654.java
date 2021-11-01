package BJ;
//이분 탐색
//랜선 자르기

import java.util.Scanner;

public class No1654 {

    static boolean check(long[] a, int n, long x) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += a[i] / x;
        }
        return cnt >= n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        long[] a = new long[n];
        long max = 0;
        for (int i = 0; i < k; i++) {
            a[i] = sc.nextLong();
            max = Math.max(max, a[i]);
        }

        long l = 1;
        long r = max;
        long ans = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (check(a, n, mid)) {
                ans = Math.max(mid, ans);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
