package BJ;
//위상 정렬
//게임 개발

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class No1516 {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer>[] arr = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        int[] indegree = new int[n + 1];
        int[] buildTime = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            buildTime[i] = sc.nextInt();
            while (true) {
                int command = sc.nextInt();
                if (command == -1) {
                    break;
                }
                arr[command].add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] result = new int[n + 1];
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : arr[now]) {
                indegree[next]--;
                result[next] = Math.max(result[next], result[now] + buildTime[now]);
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(result[i] + buildTime[i]);
        }
    }
}
