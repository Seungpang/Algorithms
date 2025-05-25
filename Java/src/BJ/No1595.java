package BJ;
// 북쪽나라의 도로

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No1595 {

    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new ArrayList[10001];
        for (int i = 0; i <= 10000; i++) {
            graph[i] = new ArrayList<>();
        }

        String line;
        while ((line = br.readLine()) != null && !line.trim().isEmpty()) {
            String[] split = line.trim().split(" ");
            int u = Integer.parseInt(split[0]);
            int v = Integer.parseInt(split[1]);
            int w = Integer.parseInt(split[2]);
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        int[] firstBfs = bfs(1);
        int farthestNode = firstBfs[0];

        int[] secondBfs = bfs(farthestNode);
        int maxDist = secondBfs[1];

        System.out.println(maxDist);
    }

    static int[] bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[10001];
        queue.add(new int[]{start, 0});
        visited[start] = true;

        int maxDist = 0;
        int farthestNode = start;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0], dist = curr[1];

            if (dist > maxDist) {
                maxDist = dist;
                farthestNode = node;
            }

            for (Node next : graph[node]) {
                if (!visited[next.to]) {
                    visited[next.to] = true;
                    queue.add(new int[]{next.to, dist + next.weight});
                }
            }
        }

        return new int[]{farthestNode, maxDist};
    }

    static class Node {
        int to, weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
