package BJ;
// 등수 찾기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class No17616 {

    static List<Integer>[] higher, lower;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        higher = new List[N+1];
        lower = new List[N+1];
        for (int i = 1; i <= N; i++) {
            higher[i] = new ArrayList<>();
            lower[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            higher[B].add(A);
            lower[A].add(B);
        }

        int higherCount = bfs(higher, X);
        int lowerCount = bfs(lower, X);

        int highestRank = higherCount + 1;
        int lowestRank = N - lowerCount;

        System.out.println(highestRank + " " + lowestRank);
    }

    static int bfs(List<Integer>[] graph, int start) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next : graph[curr]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                    count++;
                }
            }
        }

        return count;
    }
}
