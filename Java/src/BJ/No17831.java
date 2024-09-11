package BJ;
// 대기업 승범이네

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No17831 {

    static List<Integer>[] tree;
    static int[] A;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            tree[parent].add(i);
        }

        A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        dp = new long[N + 1][2];
        dfs(1);

        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    static void dfs(int node) {
        dp[node][0] = 0;
        dp[node][1] = 0;

        for (int child : tree[node]) {
            dfs(child);
            dp[node][0] += Math.max(dp[child][0], dp[child][1]);
        }

        for (int child : tree[node]) {
            long temp = A[node] * (long)A[child] + dp[node][0] - Math.max(dp[child][0], dp[child][1]) + dp[child][0];
            dp[node][1] = Math.max(dp[node][1], temp);
        }
    }
}
