package BJ;
// 꽃길

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14620 {

    static int N;
    static int[][] map;
    static boolean[][] planted;
    static int minCost = Integer.MAX_VALUE;
    static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {0, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        planted = new boolean[N][N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        dfs(0, 0);

        System.out.println(minCost);
    }

    static void dfs(int count, int cost) {
        if (count == 3) {
            minCost = Math.min(minCost, cost);
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j=1; j < N - 1; j++) {
                if (isValid(i, j)) {
                    int newCost = cost + getCost(i, j);
                    plantFlower(i, j);
                    dfs(count + 1, newCost);
                    removeFlower(i, j);
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (planted[nx][ny]) return false;
        }
        return true;
    }

    static int getCost(int x, int y) {
        int sum = 0;
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            sum += map[nx][ny];
        }
        return sum;
    }

    static void plantFlower(int x, int y) {
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            planted[nx][ny] = true;
        }
    }

    static void removeFlower(int x, int y) {
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            planted[nx][ny] = false;
        }
    }
}
