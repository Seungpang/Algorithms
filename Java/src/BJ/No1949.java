package BJ;
// 우수 마을

import java.util.ArrayList;
import java.util.Scanner;

public class No1949 {

    static int N;
    static int[] population;
    static ArrayList<Integer>[] adj;
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        population = new int[N + 1];
        adj = new ArrayList[N + 1];
        dp = new int[N + 1][2];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            population[i] = sc.nextInt();
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        dfs(1);

        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    static void dfs(int u) {
        visited[u] = true;

        dp[u][0] = 0;
        dp[u][1] = population[u];

        for (int v : adj[u]) {
            if (!visited[v]) {
                visited[v] = true;
                dfs(v);

                dp[u][0] += Math.max(dp[v][0], dp[v][1]);
                dp[u][1] += dp[v][0];
            }
        }
    }
}
