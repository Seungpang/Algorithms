package BJ;
// 골목 대장 호석 - 기능성

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No20168 {

    static List<Node>[] graph;
    static boolean[] visited;
    static int N, A, B, C;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }

        visited[A] = true;
        dfs(A, 0, 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void dfs(int curr, int totalCost, int maxCost) {
        if (totalCost > C) {
            return;
        }

        if (curr == B) {
            answer = Math.min(answer, maxCost);
            return;
        }

        for (Node next : graph[curr]) {
            if (!visited[next.end]) {
                visited[next.end] = true;
                dfs(next.end, totalCost + next.cost, Math.max(maxCost, next.cost));
                visited[next.end] = false;
            }
        }
    }

    static class Node {
        int end, cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}
