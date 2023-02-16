package BJ;
//그래프
//연결 요소의 개수

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class No11724 {

    static List<Integer>[] a;
    static boolean[] check;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        a = new ArrayList[n + 1];
        check = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            a[from].add(to);
            a[to].add(from);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    private static void dfs(int i) {
        if (check[i]) {
            return;
        }
        check[i] = true;
        for (int num : a[i]) {
            if (!check[num]) {
                dfs(num);
            }
        }
    }

    private static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        check[i] = true;
        while (!q.isEmpty()) {
            int nowNode = q.poll();
            for (int num : a[i]) {
                if (!check[num]) {
                    check[num] = true;
                    q.add(num);
                }
            }
        }
    }
}
