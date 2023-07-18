package BJ;
// 민준이와 마산 그리고 건우

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No18223 {

    static List<Node>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        arr = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr[start].add(new Node(end, weight));
            arr[end].add(new Node(start, weight));
        }

        int firstPath = dijkstra(1, V, V);
        int secondPath = dijkstra(1, P, V) + dijkstra(P, V, V);

        if (firstPath == secondPath) {
            System.out.println("SAVE HIM");
        } else {
            System.out.println("GOOD BYE");
        }
    }

    static int dijkstra(int start, int end, int V) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        int[] dist = new int[V + 1];
        boolean[] visited = new boolean[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();
            int now = nowNode.targetNode;
            if (!visited[now]) {
                visited[now] = true;
                for (Node next : arr[now]) {
                    if (!visited[next.targetNode] && dist[next.targetNode] > dist[now] + next.value) {
                        dist[next.targetNode] = dist[now] + next.value;
                        pq.add(new Node(next.targetNode, dist[next.targetNode]));
                    }
                }
            }
        }
        return dist[end];
    }

    static class Node implements Comparable<Node> {
        int targetNode;
        int value;

        public Node(int targetNode, int value) {
            this.targetNode = targetNode;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
