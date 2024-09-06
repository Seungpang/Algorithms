package BJ;
// 전단지 돌리기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No19542 {

    static List<Integer>[] tree;
    static int D, S;
    static long totalDistance = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        tree = new List[N+1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree[x].add(y);
            tree[y].add(x);
        }

        dfs(S, -1);

        System.out.println(totalDistance * 2);
    }

    static int dfs(int node, int parent) {
        int max = 0;

        for (int child : tree[node]) {
            if (child != parent) {
                max = Math.max(max, dfs(child, node) + 1);
            }
        }
        if (node != S && max >= D) {
            totalDistance++;
        }
        return max;
    }
}
