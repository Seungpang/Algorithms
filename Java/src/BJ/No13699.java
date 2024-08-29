package BJ;
// 점화식

import java.math.BigInteger;
import java.util.Scanner;

public class No13699 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        BigInteger[] t = new BigInteger[36];
        t[0] = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            t[i] = BigInteger.ZERO;
            for (int j = 0; j < i; j++) {
                t[i] = t[i].add(t[j].multiply(t[i - 1 - j]));
            }
        }

        System.out.println(t[n]);
    }
}
