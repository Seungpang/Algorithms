package BJ;
//트리
//트리의 지름

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class No1167 {

    static class Edge {

        public int e;
        public int value;

        public Edge(final int e, final int value) {
            this.e = e;
            this.value = value;
        }
    }

    static List<Edge>[] a;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            while (true) {
                int y = sc.nextInt();
                if (y == -1) break;
                int z = sc.nextInt();
                a[x].add(new Edge(y, z));
            }
        }
        dist = new int[n + 1];
        visited = new boolean[n + 1];
        bfs(1);
        int max = 1;
        for (int i = 2; i <= n; i++) {
            if (dist[i] > dist[max]) {
                max = i;
            }
        }
        dist = new int[n + 1];
        visited = new boolean[n + 1];
        bfs(max);
        Arrays.sort(dist);
        System.out.println(dist[n]);
    }

    private static void bfs(int index) {
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        visited[index] = true;
        while (!q.isEmpty()) {
            int nowNode = q.poll();
            for (Edge edge : a[nowNode]) {
                int e = edge.e;
                int v = edge.value;
                if (!visited[e]) {
                    visited[e] = true;
                    q.add(e);
                    dist[e] = dist[nowNode] + v;
                }
            }
        }
    }
}
