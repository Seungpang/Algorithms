package BJ;
// 퍼레이드

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No16168 {
    static List<Integer>[] a;
    static int[][] circuit;
    static String result = "NO";
    static int V, E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        a = new ArrayList[V];
        circuit = new int[V][V];

        for (int i = 0; i < V; i++) {
            a[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            a[start].add(end);
            a[end].add(start);
        }

        for (int i = 0; i < V; i++) {
            dfs(i, i, 0);
        }

        System.out.println(result);
    }

    static void dfs(int now, int num, int count) {
        if (count == E) {
            result = "YES";
            return;
        }
        for (Integer next : a[now]) {
            if (circuit[now][next] == num || circuit[next][now] == num) {
                continue;
            }
            circuit[now][next] = circuit[next][now] = num;
            dfs(next, num, count + 1);
        }
    }
}
