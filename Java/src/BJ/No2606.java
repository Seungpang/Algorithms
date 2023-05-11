package BJ;
// 바이러스
// bfs

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No2606 {

    static List<Integer>[] arr;
    static boolean[] visited;
    static int virusCount;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            arr[start].add(end);
            arr[end].add(start);
        }

        visited = new boolean[n + 1];
//        Queue<Integer> q = new LinkedList<>();
//        q.add(1);
//        visited[1] = true;
//        int virusCount = 0;
//        while (!q.isEmpty()) {
//            int now = q.poll();
//            for (int computer : arr[now]) {
//                if (!visited[computer]) {
//                    visited[computer] = true;
//                    q.add(computer);
//                    virusCount++;
//                }
//            }
//        }
        visited[1] = true;
        dfs(1);
        System.out.println(virusCount);
    }

    public static void dfs(int computerNum) {
        for (int computer : arr[computerNum]) {
            if (!visited[computer]) {
                visited[computer] = true;
                virusCount++;
                dfs(computer);
            }
        }
    }
}
