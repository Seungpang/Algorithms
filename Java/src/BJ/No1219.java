package BJ;
// 오민식의 고민

import java.util.Arrays;
import java.util.Scanner;

public class No1219 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int startCity = sc.nextInt();
        int endCity = sc.nextInt();
        int m = sc.nextInt();
        Edge[] edges = new Edge[m];
        long[] distance = new long[n];
        long[] cityMoney = new long[n];
        Arrays.fill(distance, Long.MIN_VALUE);
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int price = sc.nextInt();
            edges[i] = new Edge(start, end, price);
        }

        for (int i = 0; i < n; i++) {
            cityMoney[i] = sc.nextInt();
        }

        distance[startCity] = cityMoney[startCity];
        for (int i = 0; i <= n + 100; i++) {
            for (int j = 0; j < m; j++) {
                Edge edge = edges[j];
                if (distance[edge.start] == Long.MIN_VALUE) {
                    continue;
                } else if (distance[edge.start] == Long.MAX_VALUE) {
                    distance[edge.end] = Long.MAX_VALUE;
                } else if (distance[edge.end] < distance[edge.start] + cityMoney[edge.end] - edge.value) {
                    distance[edge.end] = distance[edge.start] + cityMoney[edge.end] - edge.value;
                    if (i >= n - 1) {
                        distance[edge.end] = Long.MAX_VALUE;
                    }
                }
            }
        }
        if (distance[endCity] == Long.MIN_VALUE) {
            System.out.println("gg");
        } else if (distance[endCity] == Long.MAX_VALUE) {
            System.out.println("Gee");
        } else {
            System.out.println(distance[endCity]);
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
