package BJ;
// 촌수 계산

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class No2644 {
    static List<Integer>[] a;
    static boolean[] visited;
    static int result = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new List[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }

        int resultStart = sc.nextInt();
        int resultEnd = sc.nextInt();

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            a[start].add(end);
            a[end].add(start);
        }

        bfs(resultStart, resultEnd, 0);
        System.out.println(result);
    }

    public static void dfs(int num, int target, int depth) {
        visited[num] = true;
        for (int n : a[num]) {
            if (!visited[n]) {
                if (n == target) {
                    result = depth + 1;
                    return;
                }
                dfs(n, target, depth + 1);
            }
        }
    }

    public static void bfs(int num, int target, int depth) {
        Queue<Person> q = new LinkedList<>();
        q.add(new Person(num, depth));
        visited[num] = true;
        while (!q.isEmpty()) {
            Person now = q.poll();
            for (int n : a[now.num]) {
                if (!visited[n]) {
                    if (n == target) {
                        result = now.depth + 1;
                    }
                    visited[n] = true;
                    q.add(new Person(n, now.depth + 1));
                }
            }
        }
    }

    static class Person {
        int num;
        int depth;

        public Person(final int num, final int depth) {
            this.num = num;
            this.depth = depth;
        }
    }
}
