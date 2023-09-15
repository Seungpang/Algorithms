package BJ;
// 실버와 소수는 둘다 S로 시작한다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No29728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= N; ++i) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int bCount = 0, sCount = 0;
        boolean lastIsB = false;

        for (int i = 1; i <= N; ++i) {
            if (!isPrime[i]) {
                bCount++;
                lastIsB = true;
            } else {
                if (lastIsB) {
                    sCount++;
                    bCount--;
                }

                sCount++;

                lastIsB = false;
            }
        }

        System.out.println(bCount + " " + sCount);
    }
}
