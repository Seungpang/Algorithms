package BJ;
// 풍선 공장

import java.util.Scanner;

public class No15810 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = sc.nextInt();
        }

        long left = 0;
        long right = Long.MAX_VALUE;
        while (left < right) {
            long mid = (left + right) / 2;
            if (canMakeBalloons(times, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }

    private static boolean canMakeBalloons(int[] times, int m, long time) {
        long totalBalloons = 0;
        for (int t : times) {
            totalBalloons += time / t;
            if (totalBalloons >= m) return true;
        }
        return false;
    }
}
