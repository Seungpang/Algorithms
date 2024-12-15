package BJ;
// 숨바꼭질

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class No6118 {

    static List<Integer>[] graph;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
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

        distance = new int[N + 1];
        Arrays.fill(distance, -1);
        bfs(1);

        int maxDistance = 0;
        int minBarn = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (distance[i] > maxDistance) {
                maxDistance = distance[i];
                minBarn = i;
                count = 1;
            } else if (distance[i] == minBarn) {
                count++;
                if (i < minBarn) {
                    minBarn = i;
                }
            }
        }

        System.out.println(minBarn + " " + maxDistance + " " + count);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        distance[start] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next : graph[curr]) {
                if (distance[next] == -1) {
                    distance[next] = distance[curr] + 1;
                    q.offer(next);
                }
            }
        }
    }
}
