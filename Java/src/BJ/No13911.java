package BJ;
// 집 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No13911 {

    static ArrayList<int[]>[] graph;
    static int V, E;
    static int[] mcDist, sbDist;
    static boolean[] isMcDonalds, isStarbucks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        isMcDonalds = new boolean[V + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            isMcDonalds[Integer.parseInt(st.nextToken())] = true;
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        isStarbucks = new boolean[V + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            isStarbucks[Integer.parseInt(st.nextToken())] = true;
        }

        mcDist = new int[V + 1];
        sbDist = new int[V + 1];
        Arrays.fill(mcDist, Integer.MAX_VALUE);
        Arrays.fill(sbDist, Integer.MAX_VALUE);

        spfa(isMcDonalds, mcDist);
        spfa(isStarbucks, sbDist);

        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= V; i++) {
            if (!isMcDonalds[i] && !isStarbucks[i] && mcDist[i] <= x && sbDist[i] <= y) {
                result = Math.min(result, mcDist[i] + sbDist[i]);
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    static void spfa(boolean[] sources, int[] dist) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] inQueue = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            if (sources[i]) {
                dist[i] = 0;
                queue.offer(i);
                inQueue[i] = true;
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            inQueue[current] = false;

            for (int[] next : graph[current]) {
                int nextNode = next[0], weight = next[1];
                if (dist[nextNode] > dist[current] + weight) {
                    dist[nextNode] = dist[current] + weight;
                    if (!inQueue[nextNode]) {
                        queue.offer(nextNode);
                        inQueue[nextNode] = true;
                    }
                }
            }
        }
    }
}
