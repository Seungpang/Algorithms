package BJ;
// ACM Craft

import java.util.*;

public class No1005 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            List<Integer>[] arr = new List[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = new ArrayList<>();
            }

            int[] indegree = new int[n + 1];
            int[] buildTime = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                buildTime[i] = sc.nextInt();
            }

            for (int i = 0; i < k; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                arr[start].add(end);
                indegree[end]++;
            }
            int target = sc.nextInt();
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

            System.out.println(result[target] + buildTime[target]);
        }
    }
}
