package BJ;
// 뉴스 전하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No1135 {

    static List<Integer>[] graph;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] parent = new int[N];
        graph = new List[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            if (parent[i] != -1) {
                graph[parent[i]].add(i);
            }
        }

        dfs(0);

        System.out.println(dp[0]);
    }

    static void dfs(int node) {
        List<Integer> childTimes = new ArrayList<>();

        for (int child : graph[node]) {
            dfs(child);
            childTimes.add(dp[child]);
        }

        childTimes.sort(Collections.reverseOrder());

        int maxTime = 0;
        for (int i = 0; i < childTimes.size(); i++) {
            maxTime = Math.max(maxTime, childTimes.get(i) + i + 1);
        }

        dp[node] = maxTime;
    }
}
