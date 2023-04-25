package Programmers;
// 인사고과

import java.util.Arrays;

public class PG152995 {

    public static void main(String[] args) {
        final PG152995 a = new PG152995();
        System.out.println(a.solution(new int[][]{{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}}));
    }

    public int solution(int[][] scores) {
        int answer = 0;
        int target = scores[0][0] + scores[0][1];
        int[] wanho = scores[0];
        Arrays.sort(scores, (a, b) ->a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        int max = 0;
        for (int[] score : scores) {
            if (score[1] < max) {
                if (Arrays.equals(wanho, score)) {
                    return -1;
                }
            } else {
                max = Math.max(max, score[1]);
                if (target < score[0] + score[1]) {
                    answer++;
                }
            }
        }
        return answer + 1;
    }
}
