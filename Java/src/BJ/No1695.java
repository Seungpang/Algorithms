package BJ;
// 팰린드롬 만들기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1695 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][N];

        for (int len = 1; len < N; len++) {
            for (int i = 0, j =len; j < N; i++, j++) {
                if (arr[i] == arr[j]) {
                    dp[i][j] = (len == 1) ? 0 : dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        System.out.println(dp[0][N - 1]);
    }
}
