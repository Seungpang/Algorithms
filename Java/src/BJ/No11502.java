package BJ;
// 세 개의 소수 문제

import java.util.Arrays;
import java.util.Scanner;

public class No11502 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        boolean[] isPrime = sieve(1000);
        while (T-- > 0) {
            int K = sc.nextInt();
            int[] result = findPrimeSum(K, isPrime);
            if (result != null) {
                System.out.println(result[0] + " " + result[1] + " " + result[2]);
            } else {
                System.out.println(0);
            }
        }
    }

    private static boolean[] sieve(final int n) {
        boolean[] isPrime = new boolean[n + 1];
        if (n >= 2) {
            Arrays.fill(isPrime, 2, n + 1, true);
        }

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    private static int[] findPrimeSum(final int n, final boolean[] isPrime) {
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                for (int j = 2; j < n; j++) {
                    if (isPrime[j]) {
                        for (int k = 2; k < n; k++) {
                            if (isPrime[k] && (i + j + k) == n) {
                                return new int[]{i, j, k};
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}
