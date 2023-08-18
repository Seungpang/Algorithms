package BJ;
// 웜홀

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class No1865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            List<Edge> edges = new ArrayList<>();
            int[] distance = new int[N + 1];
            Arrays.fill(distance, Integer.MAX_VALUE);
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                edges.add(new Edge(start, end, time));
                edges.add(new Edge(end, start, time));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                edges.add(new Edge(start, end, -time));
            }

            boolean cycleExists = false;

            for (int i = 1; i <= N; i++) {
                if (bellmanFord(N, edges, i)) {
                    cycleExists = true;
                    break;
                }
            }

            System.out.println(cycleExists ? "YES" : "NO");
        }
    }

    static boolean bellmanFord(int N, List<Edge> edges, int start) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, 10000001);

        distance[start] = 0;
        boolean updated;
        for (int i = 1; i <= N; i++) {
            updated = false;
            for (Edge edge : edges) {
                if (distance[edge.start] != 10000001 && distance[edge.end] > distance[edge.start] + edge.time) {
                    distance[edge.end] = distance[edge.start] + edge.time;
                    updated = true;
                }
            }
            if (!updated) break;
            if (i == N && updated) {
                return true;
            }
        }

        return false;
    }

    static class Edge {
        int start;
        int end;
        int time;

        public Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
}
