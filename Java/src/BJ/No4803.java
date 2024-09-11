package BJ;
// 트리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No4803 {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int caseNum = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) break;

            graph = new ArrayList[n + 1];
            visited = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            int treeCount = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    if (dfs(i, 0)) treeCount++;
                }
            }

            sb.append("Case ").append(caseNum).append(": ");
            if (treeCount == 0) {
                sb.append("No trees.\n");
            } else if (treeCount == 1) {
                sb.append("There is one tree.\n");
            } else {
                sb.append("A forest of ").append(treeCount).append(" trees.\n");
            }

            caseNum++;
        }

        System.out.print(sb);
    }

    static boolean dfs(int node, int parent) {
        visited[node] = true;
        for (int next : graph[node]) {
            if (next == parent) continue;
            if (visited[next]) return false;
            if (!dfs(next, node)) return false;
        }
        return true;
    }
}
