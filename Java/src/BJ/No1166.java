package BJ;
// 선물

import java.util.Scanner;

public class No1166 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long l = sc.nextLong();
        long w = sc.nextLong();
        long h = sc.nextLong();

        double left = 0;
        double right = Math.max(h, Math.max(l, w));
        while (left < right) {
            double mid = (left + right) / 2;
            if (mid == right || mid == left) {
                break;
            }
            if ((long) (l / mid) * (long) (w / mid) * (long) (h / mid) >= n) {
                left = mid;
            } else {
                right = mid;
            }
        }
        System.out.println(left);
    }
}
