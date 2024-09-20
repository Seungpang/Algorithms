package BJ;
// 개구리 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15566 {

    static int N, M;
    static int[][] frogs, like, tree;
    static int[] selected;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        frogs = new int[N][4];
        like = new int[N][2];
        tree = new int[M][3];
        selected = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                frogs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            like[i][0] = Integer.parseInt(st.nextToken());
            like[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                tree[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println("NO");
    }

    static void dfs(int index) {
        if (index == N) {
            if (check()) {
                System.out.println("YES");
                for (int i = 0; i < N; i++) {
                    System.out.print((selected[i] + 1) + " ");
                }
                System.exit(0);
            }
            return;
        }

        for (int j = 0; j < 2; j++) {
            int num = like[index][j] - 1;
            if (!visited[num]) {
                visited[num] = true;
                selected[num] = index;
                dfs(index + 1);
                visited[num] = false;
            }
        }
    }

    static boolean check() {
        for (int[] log : tree) {
            int a = log[0] - 1;
            int b = log[1] - 1;
            int topic = log[2] - 1;
            int frog1 = selected[a];
            int frog2 = selected[b];
            if (frogs[frog1][topic] != frogs[frog2][topic]) {
                return false;
            }
        }
        return true;
    }
}
