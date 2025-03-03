package BJ;
// 스크루지 민호

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class No12896 {

    static List<Integer>[] graph;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        int farthestNode = bfs(1)[1];
        int diameter = bfs(farthestNode)[0];

        System.out.println((diameter + 1) / 2);
    }

    static int[] bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);
        q.offer(start);
        dist[start] = 0;
        int farthestNode = start, maxDist = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int next : graph[node]) {
                if (dist[next] == -1) {
                    dist[next] = dist[node] + 1;
                    q.offer(next);
                    if (dist[next] > maxDist) {
                        maxDist = dist[next];
                        farthestNode = next;
                    }
                }
            }
        }

        return new int[]{maxDist, farthestNode};
    }
}
