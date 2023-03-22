package Programmers;

import java.util.Arrays;

public class PG43105 {

    public static void main(String[] args) {
        final PG43105 pg43105 = new PG43105();
        System.out.println(pg43105.solution(new int[][]{
                {7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}
        }));
    }

    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        for (int i=0; i<triangle[n-1].length; i++) {
            dp[n-1][i] = triangle[n-1][i];
        }

        for (int i=n-1; i >= 1; i--) {
            for (int j=triangle[i].length -1; j >= 1; j--) {
                dp[i - 1][j - 1] = Math.max(triangle[i - 1][j - 1] + dp[i][j], triangle[i - 1][j - 1] + dp[i][j - 1]);
            }
        }

        return dp[0][0];
    }

    public int solution2(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i - 1][0];
            triangle[i][i] += triangle[i - 1][i - 1];
            for (int j = 1; j < i; j++) {
                triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
            }
        }
        return Arrays.stream(triangle[triangle.length - 1]).max().getAsInt();
    }
}
