package BJ;
//bfs
//숨바꼭질 3

import java.util.ArrayDeque;
import java.util.Scanner;

public class No13549_2 {

    public static final int MAX = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dist = new int[MAX];
        boolean[] check = new boolean[MAX];
        check[n] = true;
        dist[n] = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : new int[]{now*2, now-1, now+1}) {
                if (next >= 0 && next <MAX) {
                    if (check[next] == false) {
                        check[next] = true;
                        if (now*2 == next) {
                            q.addFirst(next);
                            dist[next] = dist[now];
                        } else {
                            q.addLast(next);
                            dist[next] = dist[now] + 1;
                        }
                    }
                }
            }
        }
        System.out.println(dist[m]);
    }
}
