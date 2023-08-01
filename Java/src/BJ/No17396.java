package BJ;
// 백도어

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No17396 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] eyesight = new int[N];
        List<Edge>[] arr = new ArrayList[N];
        long[] dist = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            eyesight[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            dist[i] = Long.MAX_VALUE;
        }
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            arr[start].add(new Edge(end, value));
            arr[end].add(new Edge(start, value));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N];
        pq.offer(new Edge(0, 0));
        dist[0] = 0;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (visited[now.end]) continue;
            visited[now.end] = true;
            for (Edge next : arr[now.end]) {
                if (eyesight[next.end] == 1 && next.end != N-1) {
                    continue;
                }
                if (dist[next.end] > dist[now.end] + next.cost) {
                    dist[next.end] = dist[now.end] + next.cost;
                    pq.offer(new Edge(next.end, dist[next.end]));
                }
            }
        }

        if (dist[N - 1] == Long.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dist[N - 1]);
        }
    }

    static class Edge implements Comparable<Edge> {
        int end;
        long cost;

        public Edge(int end, long cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(cost, o.cost);
        }
    }
}
