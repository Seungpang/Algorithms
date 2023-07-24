package BJ;
// 팰린드롬?

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10942 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[N+1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i][i] = 1;
        }

        for (int i = 1; i < N; i++) {
            if (numbers[i] == numbers[i + 1]) {
                dp[i][i + 1] = 1;
            }
        }

        for (int k = 2; k < N; k++) {
            for (int i = 1; i <= N - k; i++) {
                int j = i + k;
                if (numbers[i] == numbers[j] && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(dp[start][end]).append("\n");
        }

        System.out.println(sb);
    }
}
