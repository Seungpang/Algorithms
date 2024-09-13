package BJ;
// 나의 인생에는 수학과 함께

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17265 {

    static String[][] map;
    static int[][][] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new String[N][N];
        dp = new int[N][N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j][0] = Integer.MAX_VALUE;
                dp[i][j][1] = Integer.MIN_VALUE;
            }
        }

        dp[0][0][0] = dp[0][0][1] = Integer.parseInt(map[0][0]);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 && j == 0) continue;

                if (isNumber(map[i][j])) { // 숫자인 경우
                    int num = Integer.parseInt(map[i][j]);
                    if (i > 0 && isOperator(map[i-1][j])) {
                        String op = map[i-1][j];
                        updateDP(i, j, dp[i-1][j][0], dp[i-1][j][1], num, op);
                    }
                    if (j > 0 && isOperator(map[i][j-1])) {
                        String op = map[i][j-1];
                        updateDP(i, j, dp[i][j-1][0], dp[i][j-1][1], num, op);
                    }
                } else {
                    if (i > 0) {
                        dp[i][j][0] = Math.min(dp[i][j][0], dp[i-1][j][0]);
                        dp[i][j][1] = Math.max(dp[i][j][1], dp[i-1][j][1]);
                    }
                    if (j > 0) {
                        dp[i][j][0] = Math.min(dp[i][j][0], dp[i][j-1][0]);
                        dp[i][j][1] = Math.max(dp[i][j][1], dp[i][j-1][1]);
                    }
                }
            }
        }

        System.out.println(dp[N-1][N-1][1] + " " + dp[N-1][N-1][0]);
    }

    static void updateDP(int i, int j, int prevMin, int prevMax, int num, String op) {
        int newMin = calculate(prevMin, num, op);
        int newMax = calculate(prevMax, num, op);
        dp[i][j][0] = Math.min(dp[i][j][0], Math.min(newMin, newMax));
        dp[i][j][1] = Math.max(dp[i][j][1], Math.max(newMin, newMax));
    }

    static int calculate(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            default: return 0;
        }
    }

    static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*");
    }
}
