package BJ;
// A와 B 2

import java.util.Scanner;

public class No12919 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String T = sc.next();

        int result = go(S, T);
        System.out.println(result);
    }

    static int go(String S, String T) {
        if (S.length() == T.length()) {
            if (S.equals(T)) {
                return 1;
            }
            return 0;
        }

        if (T.charAt(T.length() - 1) == 'A') {
            if (go(S ,T.substring(0, T.length() - 1)) == 1) {
                return 1;
            }
        }

        if (T.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder();
            sb.append(T.substring(1, T.length()));
            if (go(S, sb.reverse().toString()) == 1) {
                return 1;
            }
        }

        return 0;
    }
}
