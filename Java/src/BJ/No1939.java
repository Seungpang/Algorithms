package BJ;
//이분 탐색, dfs
//중량제한

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class No1939 {

    static class Edge {
        int to, cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static ArrayList<Edge>[] a = new ArrayList[10001];
    static boolean[] check = new boolean[10001];
    static int n,m,start, end;

    static boolean dfs(int node, int limit) {
        if (check[node]) {
            return false;
        }
        check[node] = true;
        if (node == end) {
            return true;
        }

        for (Edge e : a[node]) {
            int next = e.to;
            int cost = e.cost;
            if (cost >= limit) {
                if (dfs(next, limit)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }
        while (m-- > 0) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            a[from].add(new Edge(to, cost));
            a[to].add(new Edge(from, cost));
        }
        start = sc.nextInt();
        end = sc.nextInt();

        int left = 1;
        int right = 1000000000;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            Arrays.fill(check, false);
            if (dfs(start, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
