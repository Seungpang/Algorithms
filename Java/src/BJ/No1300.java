package BJ;
//K번째 수
//이진 탐색

import java.util.Scanner;

public class No1300 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long start = 1;
        long end = k;
        long result = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;
            for (int i = 1; i <= n; i++) {
                cnt += Math.min(mid / i, n);
            }
            if (cnt < k) {
                start = mid + 1;
            } else {
                result = mid;
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}
