package BJ;
// 트리의 독립집합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No2213 {

    static int[] weights;
    static List<Integer>[] graph;
    static int[][] dp;
    static boolean[] visited;
    static List<Integer> resultNodes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        weights = new int[n+1];
        graph = new List[n + 1];
        visited = new boolean[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        dp = new int[n + 1][2];
        dfs(1);

        System.out.println(Math.max(dp[1][0], dp[1][1]));

        visited = new boolean[n+1];
        findResult(1, dp[1][1] > dp[1][0]);

        Collections.sort(resultNodes);
        for (int node : resultNodes) {
            System.out.print(node + " ");
        }
    }

    static void dfs(int node) {
        visited[node] = true;
        dp[node][0] = 0;
        dp[node][1] = weights[node];

        for (int child : graph[node]) {
            if (!visited[child]) {
                dfs(child);
                dp[node][0] += Math.max(dp[child][0], dp[child][1]);
                dp[node][1] += dp[child][0];
            }
        }
    }

    static void findResult(int node, boolean include) {
        visited[node] = true;
        if (include) {
            resultNodes.add(node);
            for (int child : graph[node]) {
                if (!visited[child]) {
                    findResult(child, false);
                }
            }
        } else {
            for (int child : graph[node]) {
                if (!visited[child]) {
                    findResult(child, dp[child][1] > dp[child][0]);
                }
            }
        }
    }
}
