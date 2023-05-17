package BJ;
// 부분 삼각 수열

import java.util.Arrays;
import java.util.Scanner;

public class No1548 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int result = n;
        Arrays.sort(a);

        if (result > 2) {
            result = -1;
            for (int i = 0; i < n - 2; i++) {
                for (int j = n - 1; j > i + 1; j--) {
                    if (a[i] + a[i + 1] > a[j]) {
                        result = Math.max(result, j - i + 1);
                    }
                }
            }

            if (result == -1) {
                result = 2;
            }
        }
        System.out.println(result);
    }
}
