package BJ;
// 기타리스트

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1495 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] V = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[N + 1][M + 1];
        dp[0][S] = true;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (dp[i - 1][j]) {
                    if (j - V[i] >= 0) {
                        dp[i][j - V[i]] = true;
                    }
                    if (j + V[i] <= M) {
                        dp[i][j + V[i]] = true;
                    }
                }
            }
        }

        int ans = -1;
        for (int i = M; i >= 0; i--) {
            if (dp[N][i]) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}
