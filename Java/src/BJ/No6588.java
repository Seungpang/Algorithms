package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No6588 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] isPrime = new boolean[10000001];
        isPrime[0] = isPrime[1] = true;
        for (int i = 2; i<=Math.sqrt(1000000); i++) {
            if(isPrime[i]) continue;
            for (int j = i * i; j < 1000000; j += i) {
                isPrime[j] = true;
            }
        }

        while (true) {
            int num = Integer.parseInt(br.readLine());
            boolean isExists = false;

            if (num == 0) {
                System.out.println(sb);
                return;
            }
            for (int i=3; i<=num; i+=2) {
                if (!isPrime[i] && !isPrime[num-i]) {
                    sb.append(num + " = " + i + " + " + (num - i)).append("\n");
                    isExists = true;

                    break;
                }
            }

            if (!isExists) {
                sb.append("Goldbach's conjecture is wrong.").append("\n");
            }
        }
    }
}
