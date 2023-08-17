package BJ;
// BOJ 거리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No12026 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[] dp = new int[N];
        Arrays.fill(dp, 1000001);
        dp[0] = 0;

        for (int i = 1; i < N; i++) {
            char target = '\0';
            if (s.charAt(i) == 'O') {
                target = 'B';
            } else if (s.charAt(i) == 'J') {
                target = 'O';
            } else {
                target = 'J';
            }

            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == target) {
                    int cost = (i - j) * (i - j);
                    dp[i] = Math.min(dp[i], dp[j] + cost);
                }
            }
        }

        if (dp[N - 1] == 1000001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N - 1]);
        }
    }
}
