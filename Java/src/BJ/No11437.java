package BJ;
// LCA

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No11437 {

    static int N, M, MAX = 17;
    static List<Integer>[] tree;
    static int[][] parent;
    static int[] depth;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        depth = new int[N + 1];
        visited = new boolean[N + 1];
        parent = new int[N + 1][MAX];

        dfs(1, 0);

        for (int k = 1; k < MAX; k++) {
            for (int node = 1; node <= N; node++) {
                parent[node][k] = parent[parent[node][k - 1]][k - 1];
            }
        }

        M = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            bw.write(lca(u, v) + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int current, int d) {
        visited[current] = true;
        depth[current] = d;

        for (int next : tree[current]) {
            if (!visited[next]) {
                parent[next][0] = current;
                dfs(next, d + 1);
            }
        }
    }

    static int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u; u = v; v = temp;
        }

        for (int k = MAX - 1; k >= 0; k--) {
            if (depth[u] - (1 << k) >= depth[v]) {
                u = parent[u][k];
            }
        }

        if (u == v) return u;

        for (int k = MAX - 1; k >= 0; k--) {
            if (parent[u][k] != 0 && parent[u][k] != parent[v][k]) {
                u = parent[u][k];
                v = parent[v][k];
            }
        }

        return parent[u][0];
    }
}
