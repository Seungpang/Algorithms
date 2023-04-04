package BJ;
// 최소비용 구하기2
// 다익스트라

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class No11779 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dist = new int[n + 1];
        int[] pre = new int[n + 1];
        List<Edge>[] arr = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        while (m-- > 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            arr[start].add(new Edge(end, value));
        }

        int startCity = sc.nextInt();
        int targetCity = sc.nextInt();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(startCity, 0));
        dist[startCity] = 0;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (dist[now.end] != now.value) continue;
            for (Edge edge : arr[now.end]) {
                if (dist[edge.end] > dist[now.end] + edge.value) {
                    dist[edge.end] = dist[now.end] + edge.value;
                    pre[edge.end] = now.end;
                    pq.offer(new Edge(edge.end, dist[edge.end]));
                }
            }
        }
        Stack<Integer> path = new Stack<>();
        int cur = targetCity;
        while (cur != startCity) {
            path.push(cur);
            cur = pre[cur];
        }
        path.push(cur);
        System.out.println(dist[targetCity]);
        System.out.println(path.size());
        while (!path.isEmpty()) {
            System.out.print(path.pop() + " ");
        }
    }

    static class Edge implements Comparable<Edge> {
        int end;
        int value;

        public Edge(final int end, final int value) {
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(final Edge o) {
            return this.value - o.value;
        }
    }
}
