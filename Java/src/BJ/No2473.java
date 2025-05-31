package BJ;
// 세 용액

import java.util.Arrays;
import java.util.Scanner;

public class No2473 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N];

        for (int i=0; i<N; i++) arr[i] = sc.nextLong();

        Arrays.sort(arr);

        long minDiff = Long.MAX_VALUE;
        long a = 0, b = 0, c = 0;
        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = arr[i] + arr[left] + arr[right];

                if (Math.abs(sum) < minDiff) {
                    minDiff = Math.abs(sum);
                    a = arr[i];
                    b = arr[left];
                    c = arr[right];
                }

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    a = arr[i];
                    b = arr[left];
                    c = arr[right];
                    break;
                }
            }
        }

        long[] result = {a, b, c};
        Arrays.sort(result);
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}
