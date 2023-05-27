package BJ;
//  수도배관공사

import java.util.Scanner;

public class No2073 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt();
        int P = sc.nextInt();
        int[][] pipes = new int[P][2];

        for (int i = 0; i < P; i++) {
            pipes[i][0] = sc.nextInt();
            pipes[i][1] = sc.nextInt();
        }


        int[] dp = new int[D + 1];

        dp[0] = Integer.MAX_VALUE;
        for (int i = 0; i < P; i++) {
            for (int j = D; j >= pipes[i][0]; j--) {
                dp[j] = Math.max(dp[j], Math.min(dp[j - pipes[i][0]], pipes[i][1]));
            }
        }
        System.out.println(dp[D]);
    }
}
