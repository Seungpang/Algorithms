package BJ;
// 정수 제곱근

import java.util.Scanner;

public class No2417 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long result = findSquareRoot(n);
        System.out.println(result);
    }

    public static long findSquareRoot(long n) {
        long result = 0;
        long left = 0, right = n;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (n <= Math.pow(mid, 2)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
