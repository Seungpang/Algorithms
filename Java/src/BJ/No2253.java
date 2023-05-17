package BJ;
// 점프

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class No2253 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();

        Set<Integer> smallStones = new HashSet<>();
        for (int i = 0; i < M; i++) {
            int stone = input.nextInt();
            smallStones.add(stone);
        }

        int[][] dp = new int[10001][(int) (Math.pow(2 * N, 0.5) + 2)];
        for (int i = 0; i < 10001; i++) {
            Arrays.fill(dp[i], 10001);
        }

        dp[1][0] = 0;
        for (int i = 2; i < N + 1; i++) {
            if (smallStones.contains(i)) {
                continue;
            }
            for (int j = 1; j < (int) (Math.pow(2 * i, 0.5)) + 1; j++) {
                dp[i][j] = Math.min(dp[i - j][j - 1], Math.min(dp[i - j][j], dp[i - j][j + 1])) + 1;
            }
        }

        int minJumps = 10002;
        for (int i = 1; i < (int) (Math.pow(2 * N, 0.5)) + 1; i++) {
            minJumps = Math.min(minJumps, dp[N][i]);
        }

        if (minJumps == 10002) {
            minJumps = -1;
        }

        System.out.println(minJumps);
    }
}
