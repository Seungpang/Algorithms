package BJ;
// 좋은 수열

import java.util.Scanner;

public class No2661 {

    static long answer = Long.MAX_VALUE;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        go("");
    }

    static void go(String result) {
        if (result.length() == n) {
            System.out.println(result);
            System.exit(0);
        } else {
            for (int i = 1; i <= 3; i++) {
                if (isGoodSequence(result + i)) {
                    go(result + i);
                }
            }
        }
    }

    static boolean isGoodSequence(String s) {
        int len = s.length() / 2;

        for (int i = 1; i <= len; i++) {
            if (s.substring(s.length() - i).equals(s.substring(s.length() - 2 * i, s.length() - i))) {
                return false;
            }
        }
        return true;
    }
}
