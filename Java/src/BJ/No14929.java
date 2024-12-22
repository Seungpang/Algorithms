package BJ;
// 귀찮아 (SIB)

import java.util.Scanner;

public class No14929 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        long sum = 0;

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            sum += x[i];
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            sum -= x[i];
            result += (long) x[i] * sum;
        }

        System.out.println(result);
    }
}
