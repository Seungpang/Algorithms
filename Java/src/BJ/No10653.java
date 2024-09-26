package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No10653 {

    static int N, K;
    static int[][] checkpoints;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        checkpoints = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            checkpoints[i][0] = Integer.parseInt(st.nextToken());
            checkpoints[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N][K + 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }

        dp[0][0] = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= K; j++) {
                for (int skip = 0; skip <= j && i - skip - 1 >= 0; skip++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - skip - 1][j - skip] + distance(i - skip - 1, i));
                }
            }
        }

        System.out.println(dp[N - 1][K]);
    }

    static int distance(int i, int j) {
        return Math.abs(checkpoints[i][0] - checkpoints[j][0]) +
                Math.abs(checkpoints[i][1] - checkpoints[j][1]);
    }
}
