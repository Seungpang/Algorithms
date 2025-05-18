package BJ;
// 동작 그만. 밑장 빼기냐?

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No20159 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        long[] prefixEven = new long[N + 1];
        long[] prefixOdd = new long[N + 1];
        for (int i = 0; i < N; i++) {
            prefixEven[i + 1] = prefixEven[i];
            prefixOdd[i + 1] = prefixOdd[i];
            if (i % 2 == 0) {
                prefixEven[i + 1] += cards[i];
            } else {
                prefixOdd[i + 1] += cards[i];
            }
        }

        long answer = prefixEven[N];
        int lastCard = cards[N - 1];

        for (int i = 0; i < N; i++) {
            boolean isJungHoonTurn = (i % 2 == 0);
            long jungHoonSum = isJungHoonTurn ?
                    prefixEven[i] + lastCard + (prefixOdd[N - 1] - prefixOdd[i]) :
                    prefixEven[i] + (prefixOdd[N - 1] - prefixOdd[i]);
            answer = Math.max(answer, jungHoonSum);
        }

        System.out.println(answer);
    }
}
