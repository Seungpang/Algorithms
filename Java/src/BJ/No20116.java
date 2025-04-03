package BJ;
// 상자의 균형

import java.util.Scanner;

public class No20116 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int L = sc.nextInt();

        long[] arr = new long[n + 1];
        long[] prefix = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextLong();
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = 1; i < n; i++) {
            int count = n - i;
            long sum = prefix[n] - prefix[i];
            double avg = sum / (double) count;
            long left = arr[i] - L;
            long right = arr[i] + L;

            if (!(avg > left && avg < right)) {
                System.out.println("unstable");
                return;
            }
        }

        System.out.println("stable");
    }
}
