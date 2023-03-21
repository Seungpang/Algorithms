package Programmers;

import java.util.Arrays;

public class PG12949 {

    public static void main(String[] args) {
        final PG12949 pg12949 = new PG12949();
        System.out.println(Arrays.deepToString(pg12949.solution(new int[][]{
                {1, 4}, {3, 2}, {4, 1}
        }, new int[][]{
                {3, 3}, {3, 3}
        })));
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
