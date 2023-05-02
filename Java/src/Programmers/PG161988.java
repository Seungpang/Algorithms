package Programmers;
// 연속 펄스 부분 수열의 합

import java.util.Arrays;

public class PG161988 {

    public static void main(String[] args) {
        final PG161988 a = new PG161988();
        System.out.println(a.solution(new int[]{2, 3, -6, 1, 3, -1, 2, 4}));
    }

    public long solution(int[] sequence) {
        int n = sequence.length;
        long[] sum = new long[n + 1];
        int op = 1;
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + sequence[i] * op;
            op *= -1;
        }

        return Arrays.stream(sum).max().getAsLong() - Arrays.stream(sum).min().getAsLong();
    }

    public long solution2(int[] sequence) {
        int bestSum = Integer.MIN_VALUE;
        int endSum = 0;
        int endSum2 = 0;
        int op = 1;
        for (int s : sequence) {
            endSum = Math.max(endSum + s * op, s * op);
            op *= -1;
            endSum2 = Math.max(endSum2 + s * op, s * op);
            bestSum = Math.max(bestSum, Math.max(endSum, endSum2));
        }
        return bestSum;
    }
}
