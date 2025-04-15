package BJ;
// 트리와 쿼리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No15681 {

    static List<Integer>[] tree;
    static int[] subtreeSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        subtreeSize = new int[N + 1];

        // 트리 구조 생성
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            tree[U].add(V);
            tree[V].add(U);
        }

        dfs(R, -1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int U = Integer.parseInt(br.readLine());
            sb.append(subtreeSize[U]).append("\n");
        }

        System.out.print(sb);
    }

    static int dfs(int node, int parent) {
        subtreeSize[node] = 1;

        for (int child : tree[node]) {
            if (child != parent) {
                subtreeSize[node] += dfs(child, node);
            }
        }

        return subtreeSize[node];
    }
}
