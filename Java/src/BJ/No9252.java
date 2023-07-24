package BJ;
// LCS 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No9252 {
    static String s1, s2;
    static List<Character> path;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine();
        s2 = br.readLine();
        dp = new int[s1.length() + 1][s2.length() + 1];
        path = new ArrayList<>();
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[s1.length()][s2.length()]);
        findText(s1.length(), s2.length());
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i));
        }
        System.out.println();
    }

    static void findText(int r, int c) {
        if (r == 0 || c == 0) {
            return;
        }
        if (s1.charAt(r - 1) == s2.charAt(c - 1)) {
            path.add(s1.charAt(r - 1));
            findText(r - 1, c - 1);
        } else {
            if (dp[r - 1][c] > dp[r][c - 1]) {
                findText(r - 1, c);
            } else {
                findText(r, c - 1);
            }
        }
    }
}
