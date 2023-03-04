package BJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// 특정 거리의 도시 찾기
public class No18352 {

    static List<Integer>[] a;
    static int[] visited;
    static List<Integer> answer;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();
        a = new ArrayList[n + 1];
        answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            a[start].add(end);
        }
        visited = new int[n + 1];
        Arrays.fill(visited, -1);
        bfs(x);
        for (int i = 0; i <= n; i++) {
            if (visited[i] == k) {
                answer.add(i);
            }
        }
        if (answer.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(answer);
            for (int temp : answer) {
                System.out.println(temp);
            }
        }
    }

    private static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node]++;
        while (!q.isEmpty()) {
            int nowNode = q.poll();
            for (int i : a[nowNode]) {
                if (visited[i] == -1) {
                    visited[i] = visited[nowNode] + 1;
                    q.add(i);
                }
            }
        }
    }
}
