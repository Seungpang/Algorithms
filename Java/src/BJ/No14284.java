package BJ;
// 간선 이어가기 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No14284 {

    static List<Node>[] a;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        a = new List[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, 1000);
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            a[from].add(new Node(to, cost));
            a[to].add(new Node(from, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (dist[now.to] < now.cost) {
                continue;
            }
            for (Node next : a[now.to]) {
                if (dist[next.to] > dist[now.to] + next.cost) {
                    dist[next.to] = dist[now.to] + next.cost;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }
        System.out.println(dist[end]);
    }

    static class Node implements Comparable<Node> {
        int to, cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
