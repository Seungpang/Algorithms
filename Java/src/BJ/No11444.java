package BJ;
// 피보나치 수 6

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class No11444 {
    public static final long divisor = 1000000007L;
    public static Map<Long, long[][]> cache = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        if (N == 0) {
            System.out.println(0);
            return;
        }

        long[][] matrix = {
                {1, 1},
                {1, 0}
        };

        long[][] result = pow(matrix, N);
        System.out.println(result[0][1]);
    }

    public static long[][] pow(long[][] A, long n) {
        if (n == 1) {
            return A;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        long[][] sub = pow(A, n / 2);
        long[][] result;
        if (n % 2 == 0) {
            result = multiply(sub, sub);
        } else {
            result = multiply(multiply(sub, sub), A);
        }
        cache.put(n, result);
        return result;
    }

    public static long[][] multiply(long[][] A, long[][] B) {
        long[][] result = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                    result[i][j] %= divisor;
                }
            }
        }

        return result;
    }
}
