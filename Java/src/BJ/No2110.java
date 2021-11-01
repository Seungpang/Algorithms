package BJ;
//이분 탐색
//공유기 설치

import java.util.Arrays;
import java.util.Scanner;

public class No2110 {

    static boolean check(int[] a, int c, int mid) {
        int cnt = 1;
        int last = a[0];
        for (int i : a) {
            if (i - last >= mid) {
                cnt += 1;
                last = i;
            }
        }
        return cnt >= c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        int l = 1;
        int r = a[n - 1] - a[0];
        int ans = 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(a, c, mid)) {
                ans = Math.max(ans, mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
