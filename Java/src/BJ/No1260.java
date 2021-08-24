package BJ;
//그래프
//DFS와 BFS

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No1260 {
    static ArrayList<Integer>[] a;
    static boolean[] check;

    static void dfs(int x) {
        if (check[x]){
            return;
        }
        check[x] = true;
        System.out.print(x + " ");
        for (int y : a[x]) {
            if (check[y] == false) {
                dfs(y);
            }
        }
    }

    static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        check[v] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            System.out.print(x + " ");
            for (int y : a[x]) {
                if (check[y] == false) {
                    check[y] = true;
                    q.add(y);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        a = new ArrayList[n + 1];

        for (int i=1; i<=n; i++) {
            a[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            a[from].add(to);
            a[to].add(from);
        }

        for (int i=1; i<=n; i++) {
            Collections.sort(a[i]);
        }

        check = new boolean[n + 1];
        dfs(v);
        System.out.println();
        check = new boolean[n + 1];
        bfs(v);
        System.out.println();
    }
}
