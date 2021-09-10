package BJ;
//그래프
//서울 지하철 2호선

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No16947 {

    static ArrayList<Integer>[] a;
    static int[] check;
    static int[] dist;

    //-2 사이클 찾음, 포함되지 않음 -1 사이클 못찾음 0~n-1 사이클 찾음 시작 인덱스
    static int go(int x, int p) {
        if (check[x] == 1) {
            return x;
        }
        check[x] = 1;
        for (int y : a[x]) {
            if (y == p) continue;
            int res = go(y, x);
            if (res == -2) return -2;
            if (res >= 0) {
                check[x] = 2;
                if (x == res) return -2;
                else return res;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new ArrayList[n];
        dist = new int[n];
        check = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = new ArrayList<>();
        }

        for (int i=0; i<n; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            a[u].add(v);
            a[v].add(u);
        }
        go(0, -1);
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<n; i++) {
            if (check[i] == 2) { // 순환선인 경우
                dist[i] = 0;
                q.add(i);
            } else {
                dist[i] = -1;
            }
        }
        while (!q.isEmpty()) {
            int x = q.remove();
            for (int y : a[x]) {
                if (dist[y] == -1) { //순환선이 아닌경우
                    q.add(y);
                    dist[y] = dist[x] + 1;
                }
            }
        }
        for (int i=0; i<n; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
}
