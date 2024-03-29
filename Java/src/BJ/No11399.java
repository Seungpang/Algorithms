package BJ;
// ATM
// 그리디

import java.util.Arrays;
import java.util.Scanner;

public class No11399 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }

        Arrays.sort(p);
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += p[i] * (n - i);
        }
        System.out.println(result);
    }
}
