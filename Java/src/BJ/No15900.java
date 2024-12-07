package BJ;
// 나무 탈출

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class No15900 {

    static List<Integer>[] tree;
    static boolean[] visited;
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new List[N+1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new LinkedList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        visited = new boolean[N + 1];
        total = 0;

        dfs(1, 0);

        System.out.println(total % 2 == 1 ? "Yes" : "No");
    }

    static void dfs(int node, int depth) {
        visited[node] = true;
        boolean isLeaf = true;

        for (int neighbor : tree[node]) {
            if (!visited[neighbor]) {
                isLeaf = false;
                dfs(neighbor, depth + 1);
            }
        }

        if (isLeaf) {
            total += depth;
        }
    }
}
