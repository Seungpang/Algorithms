package BJ;

import java.util.Scanner;

public class No10971 {

    static int N;
    static int[][] W;
    static boolean[] visited;
    static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        W = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                W[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            tsp(i, i, 0, 1);
            visited[i] = false;
        }

        System.out.println(minCost);
    }

    static void tsp(int start, int current, int cost, int count) {
        if (count == N) {
            if (W[current][start] != 0) {
                minCost = Math.min(minCost, cost + W[current][start]);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && W[current][i] != 0) {
                visited[i] = true;
                tsp(start, i, cost + W[current][i], count + 1);
                visited[i] = false;
            }
        }
    }
}
