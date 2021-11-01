package BJ;
//이분 탐색
//수 이어 쓰기2

import java.util.Scanner;

public class No1790 {

    static long check(int n) {
        long ans = 0;
        for (int i = 1, len = 1; i <= n; i *= 10, len++) {
            int end = i * 10 - 1;
            if (end > n) {
                end = n;
            }
            ans += (long) (end - i + 1) * len;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        if (check(n) < k) {
            System.out.println(-1);
            System.exit(0);
        }

        int left = 1;
        int right = n;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid) < k) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        String s = Integer.toString(ans);
        long l = check(ans);
        System.out.println(s.charAt(s.length() - (int) (l - k) - 1));
    }
}
