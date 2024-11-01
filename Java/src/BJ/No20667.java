package BJ;
// 크롬

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No20667 {

    static final int M_MAX = 1000;
    static final int P_MAX = 500;

    static int N, M, K;
    static long[][] dp;
    static int[] cpu, memory, priority;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new long[P_MAX + 1][M_MAX + 2];
        for (int i = 0; i <= P_MAX; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        cpu = new int[N + 1];
        memory = new int[N + 1];
        priority = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            cpu[i] = Integer.parseInt(st.nextToken());
            memory[i] = Integer.parseInt(st.nextToken());
            priority[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = P_MAX; j >= 0; j--) {
                for (int k = M_MAX + 1; k >= 0; k--) {
                    if (j + priority[i] > P_MAX) continue;
                    if (dp[j][k] == Integer.MIN_VALUE) continue;

                    if (k + cpu[i] <= M_MAX) {
                        dp[j + priority[i]][k + cpu[i]] = Math.max(dp[j + priority[i]][k + cpu[i]], dp[j][k] + memory[i]);
                    }

                    if (k + cpu[i] > M_MAX) {
                        dp[j + priority[i]][M_MAX + 1] = Math.max(dp[j + priority[i]][M_MAX + 1], dp[j][k] + memory[i]);
                    }
                }
            }
        }

        int answer = -1;
        for (int i = 0; i <= P_MAX; i++) {
            for (int j = M; j <= M_MAX + 1; j++) {
                if (dp[i][j] >= K) {
                    if (answer == -1 || answer > i) {
                        answer = i;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
