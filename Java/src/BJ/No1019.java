package BJ;
// 책 페이지

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1019 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] counts = new long[10];
        long point = 1;
        int start = 1;

        while (start <= n) {
            while (n % 10 != 9 && start <= n) {
                countNumbers(n, counts, point);
                n--;
            }

            if (start > n) break;

            while (start % 10 != 0) {
                countNumbers(start, counts, point);
                start++;
            }

            start /= 10;
            n /= 10;

            for (int i = 0; i < 10; i++) {
                counts[i] += (n - start + 1) * point;
            }

            point *= 10;
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(counts[i] + " ");
        }
    }

    static void countNumbers(long num, long[] counts, long point) {
        while (num > 0) {
            counts[(int) (num % 10)] += point;
            num /= 10;
        }
    }
}
