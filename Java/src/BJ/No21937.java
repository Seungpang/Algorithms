package BJ;
// 작업

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No21937 {

    static List<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[end].add(start);
        }

        visited = new boolean[N + 1];
        int X = Integer.parseInt(br.readLine());
        dfs(X);

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                count++;
            }
        }

        System.out.println(count - 1);
    }

    static void dfs(int node) {
        visited[node] = true;
        for (int next : arr[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
