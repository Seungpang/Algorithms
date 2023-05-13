package BJ;
// 조합

import java.math.BigInteger;
import java.util.Scanner;

public class No2407 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        BigInteger result = BigInteger.ONE;
        for (int i = 0; i < m; i++) {
            result = result.multiply(new BigInteger(String.valueOf(n - i)))
                    .divide(new BigInteger(String.valueOf(i + 1)));
        }

        System.out.println(result);
    }
}
