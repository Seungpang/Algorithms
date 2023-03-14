package BJ;
// 임계경로
// 위상정렬
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class No1948 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Node>[] arr = new ArrayList[n + 1];
        List<Node>[] reverseArr = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
            reverseArr[i] = new ArrayList<>();
        }

        int[] indegree = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            arr[start].add(new Node(end, value));
            reverseArr[end].add(new Node(start, value));
            indegree[end]++;
        }

        int startCity = sc.nextInt();
        int endCity = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        q.offer(startCity);
        int[] result = new int[n + 1];
        while (!q.isEmpty()) {
            int now = q.poll();
            for (Node next : arr[now]) {
                indegree[next.targetNode]--;
                result[next.targetNode] = Math.max(result[next.targetNode], result[now] + next.value);
                if (indegree[next.targetNode] == 0) {
                    q.offer(next.targetNode);
                }
            }
        }

        int resultCount = 0;
        boolean[] visited = new boolean[n + 1];
        q = new LinkedList<>();
        q.offer(endCity);
        visited[endCity] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (Node next : reverseArr[now]) {
                if (result[next.targetNode] + next.value == result[now]) {
                    resultCount++;
                    if (!visited[next.targetNode]) {
                        visited[next.targetNode] = true;
                        q.offer(next.targetNode);
                    }
                }
            }
        }
        System.out.println(result[endCity]);
        System.out.println(resultCount);
    }

    static class Node {
        int targetNode;
        int value;

        Node(final int targetNode, final int value) {
            this.targetNode = targetNode;
            this.value = value;
        }
    }
}
