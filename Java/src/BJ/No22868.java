package BJ;
// 산책 (small)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class No22868 {

    static List<Integer>[] graph;
    static boolean[] visited;
    static int N, M, S, E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        List<Integer> pathToE = bfs(S, E, new boolean[N + 1]);

        for (int node : pathToE) {
            visited[node] = true;
        }
        visited[S] = false;
        visited[E] = false;

        List<Integer> pathToS = bfs(E, S, visited);

        System.out.println(pathToE.size() + pathToS.size() - 2);
    }

    static List<Integer> bfs(int start, int end, boolean[] visitedNodes) {
        Queue<Integer> queue = new LinkedList<>();
        int[] parent = new int[N + 1];
        Arrays.fill(parent, -1);

        queue.offer(start);
        parent[start] = start;
        visitedNodes[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end) {
                return reconstructPath(parent, start, end);
            }

            for (int next : graph[current]) {
                if (parent[next] == -1 && !visitedNodes[next]) {
                    queue.offer(next);
                    parent[next] = current;
                    visitedNodes[next] = true;
                }
            }
        }

        return new ArrayList<>();
    }

    static List<Integer> reconstructPath(int[] parent, int start, int end) {
        List<Integer> path = new ArrayList<>();
        for (int at = end; at != start; at = parent[at]) {
            path.add(at);
        }
        path.add(start);
        Collections.reverse(path);
        return path;
    }
}
