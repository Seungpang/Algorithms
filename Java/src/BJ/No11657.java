package BJ;
// 타임머신
// 벨만-포드

import java.util.Arrays;
import java.util.Scanner;

public class No11657 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Edge[] edges = new Edge[m + 1];
        long[] distance = new long[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edges[i] = new Edge(a, b, c);
        }

        distance[1] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Edge edge = edges[j];
                if (distance[edge.start] != Integer.MAX_VALUE
                        && distance[edge.end] > distance[edge.start] + edge.value) {
                    distance[edge.end] = distance[edge.start] + edge.value;
                }
            }
        }

        boolean minusCycle = false;
        for (int i = 0; i < m; i++) {
            Edge edge = edges[i];
            if (distance[edge.start] != Integer.MAX_VALUE
                    && distance[edge.end] > distance[edge.start] + edge.value) {
                minusCycle = true;
                break;
            }
        }

        if (!minusCycle) {
            for (int i = 2; i <= n; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(distance[i]);
                }
            }
        } else {
            System.out.println("-1");
        }

    }

    static class Edge {
        int start;
        int end;
        int value;

        public Edge(final int start, final int end, final int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
}
