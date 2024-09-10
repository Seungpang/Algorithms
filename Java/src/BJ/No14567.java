package BJ;
// 선수과목 (Prerequisite)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class No14567 {

    static int[] indegree;
    static int[] term;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        int M =sc.nextInt();

        List<Integer>[] graph = new List[N + 1];
        indegree = new int[N + 1];
        term = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            term[i] = 1;
        }

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            graph[A].add(B);
            indegree[B]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                    term[next] = term[now] + 1;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(term[i] + " ");
        }
    }
}
