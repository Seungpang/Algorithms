package codingInterview;

import java.util.ArrayList;
import java.util.List;

public class LC323 {

    public static void main(String[] args) {
        final LC323 lc323 = new LC323();
        System.out.println(lc323.countComponents(5, new int[][]{
                {0, 1}, {1, 2}, {3, 4}
        }));
    }

    public int countComponents(int n, int[][] edges) {
        int count = 0;
        List<Integer>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }

        int[] visited = new int[n];
        for (int i=0; i<n; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(adjList, visited, i);
            }
        }
        return count;
    }

    private void dfs(List<Integer>[] adjList, int[] visited, int startNode) {
        visited[startNode] = 1;

        for (int i = 0; i < adjList[startNode].size(); i++) {
            if (visited[adjList[startNode].get(i)] == 0) {
                dfs(adjList, visited, adjList[startNode].get(i));
            }
        }
    }
}
