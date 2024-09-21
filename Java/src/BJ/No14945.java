package BJ;
// 불장난

import java.util.Scanner;

public class No14945 {
    static final int MOD = 10007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][][] dp = new int[n + 1][n + 1][n + 1];
        dp[1][1][1] = 1;

        for (int time = 1; time <= n; time++) {
            for (int pos1 = 1; pos1 <= time; pos1++) {
                for (int pos2 = 1; pos2 <= time; pos2++) {
                    if (pos1 == pos2) continue;

                    for (int move1 = 0; move1 <= 1; move1++) {
                        int prevPos1 = pos1 - move1;
                        if (prevPos1 < 0 || prevPos1 > time - 1) continue;

                        for (int move2 = 0; move2 <= 1; move2++) {
                            int prevPos2 = pos2 - move2;
                            if (prevPos2 < 0 || prevPos2 > time - 1) continue;

                            dp[time][pos1][pos2] = (dp[time][pos1][pos2] + dp[time - 1][prevPos1][prevPos2]) % MOD;
                        }
                    }
                }
            }
        }

        int result = 0;
        for (int pos1 = 0; pos1 <= n; pos1++) {
            for (int pos2 = 0; pos2 <= n; pos2++) {
                if (pos1 != pos2) {
                    result = (result + dp[n][pos1][pos2]) % MOD;
                }
            }
        }

        System.out.println(result);
    }
}
