package BJ;
//bfs
//숨바꼭질 4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No13913 {

    static final int MAX = 200001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dist = new int[MAX];
        boolean[] check = new boolean[MAX];
        int[] from = new int[MAX];
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        check[N] = true;
        dist[N] = 0;
        while (!q.isEmpty()) {
            int now = q.remove();
            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (next < MAX && next >= 0 && check[next] == false) {
                    q.offer(next);
                    check[next] = true;
                    dist[next] = dist[now] + 1;
                    from[next] = now;
                }
            }
        }
        System.out.println(dist[K]);
        print(from, N, K);
        System.out.println();
    }

    public static void print(int[] from, int n, int k) {
        if (n != k) {
            print(from, n, from[k]);
        }
        System.out.print(k + " ");
    }
}
