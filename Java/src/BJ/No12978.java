package BJ;
// 스크루지 민호 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No12978 {

    static List<Integer>[] graph;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] =  new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        dp = new int[N + 1][2];
        dfs(1, 0);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int node, int parent) {
        dp[node][0] = 0;
        dp[node][1] = 1;

        for (int child : graph[node]) {
            if (child != parent) {
                dfs(child, node);
                dp[node][0] += dp[child][1];
                dp[node][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }
}
