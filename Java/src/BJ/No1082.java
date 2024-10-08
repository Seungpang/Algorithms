package BJ;
// 방 번호

import java.util.Arrays;
import java.util.Scanner;

public class No1082 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = sc.nextInt();
        }
        int M = sc.nextInt();

        String[] dp = new String[M + 1];
        Arrays.fill(dp, "");

        for (int money = 0; money <= M; money++) {
            for (int digit = 0; digit < N; digit++) {
                if (P[digit] <= money) {
                    String newNum = dp[money - P[digit]] + digit;
                    if (newNum.charAt(0) != '0' || newNum.length() == 1) {
                        if (newNum.length() > dp[money].length() ||
                                (newNum.length() == dp[money].length() && newNum.compareTo(dp[money]) > 0)) {
                            dp[money] = newNum;
                        }
                    }
                }
            }
        }

        System.out.println(dp[M].isEmpty() ? "0" : dp[M]);
    }
}
