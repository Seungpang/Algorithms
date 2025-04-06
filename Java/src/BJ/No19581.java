package BJ;
// 두 번째 트리의 지름

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No19581 {

    static List<Edge>[] tree;
    static boolean[] visited;
    static int maxDistance;
    static int endNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            String[] info = br.readLine().split(" ");
            int start = Integer.parseInt(info[0]);
            int end = Integer.parseInt(info[1]);
            int value = Integer.parseInt(info[2]);
            tree[start].add(new Edge(end, value));
            tree[end].add(new Edge(start, value));
        }

        visited = new boolean[N + 1];
        maxDistance = 0;
        dfs(1, 0);
        int nodeA = endNode;

        visited = new boolean[N + 1];
        maxDistance = 0;
        dfs(nodeA, 0);
        int nodeB = endNode;

        visited = new boolean[N + 1];
        visited[nodeB] = true;
        maxDistance = 0;
        dfs(nodeA, 0);
        int resultA = maxDistance;

        visited = new boolean[N + 1];
        visited[nodeA] = true;
        maxDistance = 0;
        dfs(nodeB, 0);
        int resultB = maxDistance;

        System.out.println(Math.max(resultA, resultB));
    }

    static void dfs(int node, int distance) {
        visited[node] = true;

        if (distance > maxDistance) {
            maxDistance = distance;
            endNode = node;
        }

        for (Edge edge : tree[node]) {
            if (!visited[edge.to]) {
                dfs(edge.to, distance + edge.weight);
            }
        }
    }

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
