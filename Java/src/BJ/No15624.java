package BJ;
// 피보나치 수 7

import java.util.Scanner;

public class No15624 {

    static long[] fibo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println(0);
            return;
        }
        fibo = new long[n + 1];
        fibonacci(n);
        System.out.println(fibo[n]);
    }

    static void fibonacci(int n) {
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1000000007;
        }
    }
}
