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

    static void dfs(int x) {
        if (check[x]) {
            return;
        }
        check[x] = true;
        for (int y : a[x]) {
            if (!check[y]) {
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
        a = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) { //인접 리스트 초기화
            a[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            a[from].add(to);
            a[to].add(from);
        }

        check = new boolean[n + 1];
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                result++;
                dfs(i);
            }
        }
        System.out.println(result);
    }
}
