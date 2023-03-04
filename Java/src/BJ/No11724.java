package BJ;
//그래프
//연결 요소의 개수

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No11724 {

    static List<Integer>[] a;
    static boolean[] visited;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        a = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            a[start].add(end);
            a[end].add(start);
        }

        visited = new boolean[n + 1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    private static void dfs(int node) {
        visited[node] = true;
        for (int i : a[node]) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
