package BJ;
//위상 정렬
//게임 개발

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1516 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        int[] indegree = new int[n + 1];
        int[] selfBuild = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            selfBuild[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int preTemp = Integer.parseInt(st.nextToken());
                if (preTemp == -1) {
                    break;
                }
                arr.get(preTemp).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[n + 1];
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : arr.get(now)) {
                indegree[next]--;
                result[next] = Math.max(result[next], result[now] + selfBuild[now]);
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(result[i] + selfBuild[i]);
        }
    }
}
