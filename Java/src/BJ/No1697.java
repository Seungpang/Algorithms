package BJ;
//bfs
//숨바꼭질

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No1697 {

    static final int MAX = 200001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[MAX];
        Arrays.fill(dist, -1);
        q.add(n);
        dist[n] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (next < 0 || next > 100000) {
                    continue;
                }
                if (dist[next] != -1) {
                    continue;
                }
                dist[next] = dist[now] + 1;
                q.offer(next);
            }
        }

        System.out.println(dist[k]);
    }
}
