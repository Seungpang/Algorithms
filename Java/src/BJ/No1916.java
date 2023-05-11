package BJ;
// 최소비용 구하기
// 다익스트라
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class No1916 {

    static int n, m;
    static List<Node>[] list;
    static int[] dist;
    static boolean[] visit;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        list = new ArrayList[n + 1];
        dist = new int[n + 1];
        visit = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 1; i <=n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();
            list[start].add(new Node(end, cost));
        }
        int startIndex = sc.nextInt();
        int endIndex = sc.nextInt();
        System.out.println(dijkstra(startIndex, endIndex));
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();
            int now = nowNode.targetNode;
            if (!visit[now]) {
                visit[now] = true;
                for (Node n : list[now]) {
                    if (!visit[n.targetNode] && dist[n.targetNode] > dist[now] + n.value) {
                        dist[n.targetNode] = dist[now] + n.value;
                        pq.add(new Node(n.targetNode, dist[n.targetNode]));
                        System.out.println(n.targetNode);
                    }
                }
            }
        }
        return dist[end];
    }

    static class Node implements Comparable<Node> {

        int targetNode;
        int value;

        public Node(final int targetNode, final int value) {
            this.targetNode = targetNode;
            this.value = value;
        }

        @Override
        public int compareTo(final Node o) {
            return value - o.value;
        }
    }
}
