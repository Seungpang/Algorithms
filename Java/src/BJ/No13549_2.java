package BJ;
//bfs
//숨바꼭질 3

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class No13549_2 {

    public static final int MAX = 100001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dist = new int[MAX];
        Arrays.fill(dist, -1);
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(n);
        dist[n] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : new int[]{now * 2, now + 1, now - 1}) {
                if (next >=0 && next < MAX && dist[next] == -1) {
                    if (next == now * 2) {
                        dist[next] = dist[now];
                        q.addFirst(next);
                    } else {
                        dist[next] = dist[now] + 1;
                        q.addLast(next);
                    }
                }
            }
        }
        System.out.println(dist[m]);
    }
}
