package BJ;
// 안정적인 네트워크

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2406 {

    static int n, m;
    static int[] parent;
    static Queue<int[]> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            union(a, b);
        }

        pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (i == 0 || j == 0 || i == j) {
                    continue;
                }
                pq.offer(new int[]{i, j, x});
            }
        }

        int count = 0;
        int sum = 0;
        List<int[]> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (find(curr[0]) != find(curr[1])) {
                sum += curr[2];
                count++;
                union(curr[0], curr[1]);
                result.add(new int[]{curr[0], curr[1]});
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sum).append(" ").append(count).append("\n");
        for (int[] arr : result) {
            sb.append(arr[0] + 1).append(" ").append(arr[1] + 1).append("\n");
        }

        System.out.println(sb);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    static int find(int a) {
        if (a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }
}
