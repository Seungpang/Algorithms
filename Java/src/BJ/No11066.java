package BJ;
// 파일 합치기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11066 {

    static int[] chapters;
    static int[][] dp; // dp[i][j]를 파일 순서 i부터 j까지의 연속된 파일들에서 합치는 최소비용
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            chapters = new int[K + 1];
            dp = new int[K + 1][K + 1];
            sum = new int[K + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; i++) {
                chapters[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + chapters[i];
            }

            System.out.println(minimumCostMerge(1, K));
        }
    }

    static int minimumCostMerge(int start, int end) {
        if (start == end) {
            return 0;
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }

        int cost = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            int temp = minimumCostMerge(start, i) + minimumCostMerge(i + 1, end) + sum[end] - sum[start - 1];
            cost = Math.min(cost, temp);
        }

        dp[start][end] = cost;
        return cost;
    }
}
