package BJ;
// 샘터

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No18513 {

    static int[] dirs = {-1, 1};
    static int n, k;
    static Set<Integer> visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        Queue<State > q = new LinkedList<>();
        visited = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int idx = Integer.parseInt(st.nextToken());
            q.offer(new State(idx, 0));
            visited.add(idx);
        }

        System.out.println(bfs(q));
    }

    static long bfs(Queue<State> q) {
        int count = 0;
        long result = 0;
        while (!q.isEmpty()) {
            State now = q.poll();
            for (int dir : dirs) {
                int next = now.idx + dir;
                if (visited.contains(next)) {
                    continue;
                }

                count++;
                result += now.dist + 1;
                if (count == k) {
                    return result;
                }
                visited.add(next);
                q.offer(new State(next, now.dist + 1));
            }
        }
        return result;
    }

    static class State {
        int idx, dist;

        public State(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
}
