package BJ;
// 작업

import java.util.*;

public class No2056 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> a = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            a.add(new ArrayList<>());
        }

        int[] indegree = new int[n + 1];
        int[] time = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            time[i] = sc.nextInt();
            int num = sc.nextInt();
            for (int j = 0; j < num; j++) {
                int temp = sc.nextInt();
                a.get(temp).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = time[i];
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : a.get(now)) {
                System.out.println(next);
                indegree[next]--;

                result[next] = Math.max(result[next], result[now] + time[next]);

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        System.out.println(Arrays.stream(result).max().getAsInt());
    }
}
