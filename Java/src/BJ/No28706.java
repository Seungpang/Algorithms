package BJ;
// 럭키 세븐

import java.util.Scanner;

public class No28706 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            boolean[][] dp = new boolean[N + 1][7];
            dp[0][1] = true;

            for (int i = 1; i <= N; i++) {
                String op1 = sc.next();
                int v1 = sc.nextInt();
                String op2 = sc.next();
                int v2 = sc.nextInt();

                for (int j = 0; j < 7; j++) {
                    if (dp[i - 1][j]) {
                        dp[i][calc(op1, j, v1)] = true;
                        dp[i][calc(op2, j, v2)] = true;
                    }
                }
            }

            System.out.println(dp[N][0] ? "LUCKY" : "UNLUCKY");
        }
    }

    public static int calc(String op, int v1, int v2) {
        if (op.equals("*")) {
            return (v1 * v2) % 7;
        } else {
            return (v1 + v2) % 7;
        }
    }
}
