package BJ;
//트리
//트리의 부모 찾기

import java.util.*;

public class No11725 {

    static List<Integer>[] adj = new ArrayList[100001];
    static int[] p = new int[100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }
        dfs(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(p[i]);
        }
    }

    public static void dfs(int cur) {
        for (int next : adj[cur]) {
            if (p[cur] == next) continue;
            p[next] = cur;
            dfs(next);
        }
    }
}
