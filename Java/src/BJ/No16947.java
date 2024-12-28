package BJ;
//그래프
//서울 지하철 2호선

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class No16947 {

    static int N;
    static List<Integer>[] graph;
    static int[] visited;
    static int[] parent;
    static boolean[] isCycle;
    static int[] dist;
    static boolean foundCycle = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new List[N + 1];
        visited = new int[N + 1];
        parent = new int[N + 1];
        isCycle = new boolean[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = -1;
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        findCycle(1);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (isCycle[i]) {
                dist[i] = 0;
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : graph[cur]) {
                if (dist[nxt] == -1) {
                    dist[nxt] = dist[cur] + 1;
                    q.add(nxt);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(dist[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    static void findCycle(int curr) {
        visited[curr] = 1;
        for (int nxt : graph[curr]) {
            if (foundCycle) return;

            if (visited[nxt] == 0) {
                parent[nxt] = curr;
                findCycle(nxt);
            } else if (visited[nxt] == 1 && parent[curr] != nxt) {
                markCycle(curr, nxt);
                foundCycle = true;
                return;
            }
        }
        visited[curr] = 2;
    }

    static void markCycle(int curr, int start) {
        isCycle[curr] = true;
        while (curr != start) {
            curr = parent[curr];
            isCycle[curr] = true;
        }
    }
}
