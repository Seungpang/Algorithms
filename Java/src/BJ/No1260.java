package BJ;
//그래프
//DFS와 BFS

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class No1260 {

    static List<Integer>[] a;
    static boolean[] check;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        a = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            a[from].add(to);
            a[to].add(from);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(a[i]);
        }

        check = new boolean[n + 1];
        dfs(v);
        System.out.println();
        check = new boolean[n + 1];
        bfs(v);
        System.out.println();
    }

    private static void dfs(final int node) {
        System.out.print(node + " ");
        check[node] = true; //방문했다고 표시
        for (int i : a[node]) {
            if (!check[i]) { // y에 방문하지 않았다면
                dfs(i);
            }
        }
    }

    private static void bfs(final int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        check[node] = true;

        while (!queue.isEmpty()) { //큐에 값이 없을때까지 반복
            int nowNode = queue.poll(); //큐에 노드를 꺼낸 후
            System.out.print(nowNode + " ");
            for (int i : a[nowNode]) {
                if (!check[i]) {
                    check[i] = true;
                    queue.add(i); //인접 노드를 큐에 삽입
                }
            }
        }
    }
}
