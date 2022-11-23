package BJ;

import java.util.Scanner;

public class No1929 {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int m = sc.nextInt();
        final int n = sc.nextInt();
        int[] arr = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = i + i; j <= n; j = j + i) {
                arr[j] = 0;
            }
        }

        for (int i = m; i <= n; i++) {
            if (arr[i] != 0) {
                System.out.println(arr[i]);
            }
        }
    }
}
