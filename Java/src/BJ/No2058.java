package BJ;
// 원자의 에너지

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class No2058 {

    static int N, M;
    static int[] energy;
    static List<Integer>[] graph;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        energy = new int[N];
        graph = new ArrayList[N];
        dp = new int[N][2];

        for (int i = 0; i < N; i++) {
            energy[i] = Integer.parseInt(br.readLine());
            graph[i] = new ArrayList<>();
        }

        Set<Integer> protonEnergies = new HashSet<>();
        for (int i = 0; i < M; i++) {
            protonEnergies.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (protonEnergies.contains(Math.abs(energy[i] - energy[j]))) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        boolean[] visited = new boolean[N];
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(i, -1, visited);
                result += Math.max(dp[i][0], dp[i][1]);
            }
        }

        System.out.println(result);
    }

    static void dfs(int node, int parent, boolean[] visited) {
        visited[node] = true;
        dp[node][0] = 0;  // 현재 노드를 선택하지 않는 경우
        dp[node][1] = energy[node];  // 현재 노드를 선택하는 경우

        for (int child : graph[node]) {
            if (child != parent && !visited[child]) {
                dfs(child, node, visited);
                dp[node][0] += Math.max(dp[child][0], dp[child][1]);
                dp[node][1] += dp[child][0];
            }
        }
    }
}
