package BJ;
//bfs
//숨바꼭질 3

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No13549 {

    public static final int MAX = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dist = new int[MAX];
        boolean[] check = new boolean[MAX];
        check[n] = true;
        dist[n] = 0;
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> next_q = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.remove();
            for (int next : new int[]{now*2, now-1, now+1}) {
                if (next >= 0 && next <MAX) {
                    if (check[next] == false) {
                        check[next] = true;
                        if (now*2 == next) {
                            q.add(next);
                            dist[next] = dist[now];
                        } else {
                            next_q.add(next);
                            dist[next] = dist[now] + 1;
                        }
                    }
                }
            }
            if (q.isEmpty()) {
                q = next_q;
                next_q = new LinkedList<>();
            }
        }
        System.out.println(dist[m]);
    }
}
