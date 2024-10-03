package BJ;
// 숨바꼭질 2

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No12851 {

    static final int MAX = 200001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] dist = new int[MAX];
        int[] count = new int[MAX];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        dist[N] = 0;
        count[N] = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : new int[]{now * 2, now + 1, now - 1}) {
                if (next >= 0 && next < MAX) {
                    if (dist[next] == -1) {
                        dist[next] = dist[now] + 1;
                        count[next] = count[now];
                        q.offer(next);
                    } else if (dist[next] == dist[now] + 1) {
                        count[next] += count[now];
                    }
                }
            }
        }

        System.out.println(dist[K]);
        System.out.println(count[K]);
    }
}
