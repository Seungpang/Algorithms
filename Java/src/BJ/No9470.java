package BJ;
// Strahler 순서

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class No9470 {

    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            graph = new List[M + 1];
            for (int i=1; i<=M; i++) {
                graph[i] = new ArrayList<>();
            }

            int[] indegree = new int[M + 1];
            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                graph[A].add(B);
                indegree[B]++;
            }

            Queue<Integer> q = new LinkedList<>();
            int[] strahler = new int[M + 1];
            int[] maxOrderCount = new int[M + 1];
            for (int i=1; i<=M; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                    strahler[i] = 1;
                }
            }

            while (!q.isEmpty()) {
                int now = q.poll();
                for (int next : graph[now]) {
                    indegree[next]--;

                    if (strahler[next] < strahler[now]) {
                        strahler[next] = strahler[now];
                        maxOrderCount[next] = 1;
                    } else if (strahler[next] == strahler[now]) {
                        maxOrderCount[next]++;
                    }

                    if (indegree[next] == 0) {
                        if (maxOrderCount[next] > 1) {
                            strahler[next]++;
                        }
                        q.offer(next);
                    }
                }
            }

            System.out.println(K + " " + strahler[M]);
        }
    }
}
