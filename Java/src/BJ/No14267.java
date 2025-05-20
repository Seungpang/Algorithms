package BJ;
// 회사 문화 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No14267 {

    static List<Integer>[] tree;
    static int[] compliment;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =  Integer.parseInt(st.nextToken());
        int m =  Integer.parseInt(st.nextToken());
        tree = new ArrayList[n+1];
        compliment = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        st = new  StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int boss =  Integer.parseInt(st.nextToken());
            if (boss != -1) {
                tree[boss].add(i);
            }
        }

        for (int i = 0; i < m; i++) {
            st = new  StringTokenizer(br.readLine());
            int employee = Integer.parseInt(st.nextToken());
            int score =  Integer.parseInt(st.nextToken());
            compliment[employee] += score;
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(compliment[i]).append(" ");
        }

        System.out.println(sb);
    }

    static void dfs(int node){
        for (int child : tree[node]) {
            compliment[child] += compliment[node];
            dfs(child);
        }
    }
}
