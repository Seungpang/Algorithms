package BJ;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// 효율적으로 해킹하기
public class No1325 {

    static List<Integer>[] a;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        a = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            a[start].add(end);
        }

        answer = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            bfs(i);
        }

        int maxValue = 0;
        for (int i = 1; i <= n; i++) {
            maxValue = Math.max(maxValue, answer[i]);
        }
        for (int i = 1; i <= n; i++) {
            if (answer[i] == maxValue) {
                System.out.print(i + " ");
            }
        }
    }

    private static void bfs(int index) {
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        visited[index] = true;
        while (!q.isEmpty()) {
            int nowNode = q.poll();
            for (int i : a[nowNode]) {
                if (!visited[i]) {
                    visited[i] = true;
                    answer[i]++;
                    q.add(i);
                }
            }
        }
    }
}
