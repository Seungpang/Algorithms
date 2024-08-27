package BJ;
// 다음 소수

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No4134 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine());
            bw.write(nextPrime(n) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static long nextPrime(long n) {
        if (n <= 1) return 2;

        for (long i = n; ; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
    }

    private static boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
