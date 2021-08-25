package BJ;
//bfs
//숨바꼭질 4

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No13913 {

    static final int MAX = 200000;

    public static void print(int[] from, int n, int k) {
        if (n != k) {
            print(from, n, from[k]);
        }
        System.out.print(k + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] dist = new int[MAX];
        boolean[] check = new boolean[MAX];
        int[] from = new int[MAX];
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        check[n] = true;
        dist[n] = 0;
        while (!q.isEmpty()) {
            int now = q.remove();
            if (now-1 >=0) {
                if (check[now-1] == false) {
                    q.add(now - 1);
                    check[now - 1] = true;
                    dist[now - 1] = dist[now] + 1;
                    from[now - 1] = now;
                }
            }
            if (now+1 < MAX) {
                if (check[now+1] == false) {
                    q.add(now + 1);
                    check[now + 1] = true;
                    dist[now + 1] = dist[now] + 1;
                    from[now + 1] = now;
                }
            }
            if (now*2 < MAX) {
                if (check[now*2] == false) {
                    q.add(now * 2);
                    check[now * 2] = true;
                    dist[now * 2] = dist[now] + 1;
                    from[now * 2] = now;
                }
            }
        }
        System.out.println(dist[k]);
        print(from, n, k);
        System.out.println();
    }
}
