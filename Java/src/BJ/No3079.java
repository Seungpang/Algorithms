package BJ;
// 입국심사

import java.util.Arrays;
import java.util.Scanner;

public class No3079 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] times = new int[N];
        long max = 0;
        for (int i = 0; i < N; i++) {
            times[i] = sc.nextInt();
            max = Math.max(max, times[i]);
        }

        Arrays.sort(times);

        long left = 0;
        long right = max * M;
        while (left < right) {
            long mid = (left + right) / 2;

            long sum = 0;
            for (int time : times) {
                sum += mid / time;
                if (sum >= M) {
                    break;
                }
            }
            if (sum >= M) {
                right = mid;
            } else {
                left = mid + 1;
            }
            System.out.println("left = " + left + " right = " + right + " mid = " + mid + " sum = " + sum);
        }

        System.out.println(left);
    }
}
