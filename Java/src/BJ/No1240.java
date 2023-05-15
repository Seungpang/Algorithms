package BJ;
// 노드사이의 거리

import java.util.*;

public class No1240 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Node>[] a = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            a[start].add(new Node(end, value));
            a[end].add(new Node(start, value));
        }
        while (m-- > 0) {
            boolean[] visited = new boolean[n + 1];
            int start = sc.nextInt();
            int end = sc.nextInt();
            Queue<Node> q = new LinkedList<>();
            q.offer(new Node(start, 0));
            visited[start] = true;
            while (!q.isEmpty()) {
                Node now = q.poll();
                for (Node next : a[now.target]) {
                    if (next.target == end) {
                        System.out.println(next.value + now.value);
                        break;
                    }
                    if (!visited[next.target]) {
                        q.offer(new Node(next.target, next.value + now.value));
                        visited[next.target] = true;
                    }
                }
            }
        }
    }

    static class Node {
        int target, value;

        public Node(int target, int value) {
            this.target = target;
            this.value = value;
        }
    }
}
