package codingInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LC787 {

    public static void main(String[] args) {
        final LC787 lc787 = new LC787();
        System.out.println(lc787.findCheapestPrice2(4, new int[][]{
                {0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}
        }, 0, 3, 1));
    }

    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            adj.computeIfAbsent(flight[0], value -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0});
        int stops = 0;

        while (stops <= k && !q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] temp = q.poll();
                int node = temp[0];
                int distance = temp[1];
                if (!adj.containsKey(node)) continue;
                for (int[] e : adj.get(node)) {
                    int neighbour = e[0];
                    int price = e[1];
                    if (price + distance >= dist[neighbour]) continue;
                    dist[neighbour] = price + distance;
                    q.add(new int[]{neighbour, dist[neighbour]});
                }
            }
            stops++;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(dist, n);
            for (int[] flight : flights) {
                if (dist[flight[0]] != Integer.MAX_VALUE) {
                    temp[flight[1]] = Math.min(temp[flight[1]], dist[flight[0]] + flight[2]);
                }
            }
            dist = temp;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
