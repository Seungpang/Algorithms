package codingInterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LC261 {

    public static void main(String[] args) {
        final LC261 lc261 = new LC261();
        System.out.println(lc261.validTree(5, new int[][]{
                {0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}
        }));
    }

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        queue.offer(0);
        seen.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adjacencyList.get(node)) {
                if (seen.contains(neighbor)) {
                    continue;
                }
                queue.offer(neighbor);
                seen.add(neighbor);
            }
        }
        return seen.size() == n;
    }
}
