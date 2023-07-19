package BJ;
// 국왕의 방문

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No2982 {
    static int N, M, K, G;
    static List<Path>[] arr;
    static int[][] times;
    static PathTime[][] kingVisitedTime;

    /**
     * 국왕의 이동 경로 시간을 미리 저장해 놓고 계산
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        int[] path = new int[G];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < G; i++) {
            path[i] = Integer.parseInt(st.nextToken());
        }

        arr = new ArrayList[N + 1];
        times = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            arr[start].add(new Path(end, time));
            arr[end].add(new Path(start, time));

            times[start][end] = time;
            times[end][start] = time;
        }

        kingVisitedTime = new PathTime[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(kingVisitedTime[i], new PathTime(0, 0));
        }
        int sum = 0;
        for (int i = 0; i < G-1; i++) {
            int start = path[i];
            int end = path[i + 1];
            kingVisitedTime[start][end] = new PathTime(sum, sum + times[start][end]);
            kingVisitedTime[end][start] = new PathTime(sum, sum + times[end][start]);
            sum += times[start][end];
        }
        System.out.println(dijkstra(A, B) - K);
    }

    static int dijkstra(int start, int end) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = K;
        PriorityQueue<Path> pq = new PriorityQueue<>();
        pq.offer(new Path(start, dist[start]));
        while (!pq.isEmpty()) {
            Path nowPath = pq.poll();
            int now = nowPath.targetPath;
            if (dist[now] < nowPath.time) {
                continue;
            }
            for (Path next : arr[now]) {
                // 통제하고 있는 시간에 방문이라면
                if (dist[now] >= kingVisitedTime[now][next.targetPath].startTime && dist[now] <= kingVisitedTime[now][next.targetPath].endTime) {
                    dist[next.targetPath] = kingVisitedTime[now][next.targetPath].endTime + next.time;
                    pq.offer(new Path(next.targetPath, dist[next.targetPath]));
                } else {
                    if (dist[next.targetPath] > dist[now] + next.time) {
                        dist[next.targetPath] = dist[now] + next.time;
                        pq.offer(new Path(next.targetPath, dist[next.targetPath]));
                    }
                }
            }
        }
        return dist[end];
    }

    static class PathTime {
        int startTime, endTime;

        public PathTime(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }


    static class Path implements Comparable<Path> {
        int targetPath;
        int time;

        public Path(int targetPath, int time) {
            this.targetPath = targetPath;
            this.time = time;
        }

        @Override
        public int compareTo(Path o) {
            return this.time - o.time;
        }
    }
}

