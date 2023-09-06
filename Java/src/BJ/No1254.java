package BJ;
// 팰린드롬 만들기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1254 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int n = S.length();
        for (int i = 0; i < n; i++) {
            if (isPalindrome(S.substring(i))) {
                System.out.println(n + i);
                break;
            }
        }
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }

        return true;
    }
}
