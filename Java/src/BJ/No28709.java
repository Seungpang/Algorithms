package BJ;
// 와일드카드 괄호 문자열

import java.util.Scanner;

public class No28709 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int t = 0; t < T; t++) {
            String s = sc.nextLine();
            System.out.println(solve(s) ? "YES" : "NO");
        }
    }

    public static boolean solve(String s) {
        char[] chars = s.toCharArray();
        int countAsterisk = 0;

        for (char c : chars) {
            if (c == '*') {
                countAsterisk++;
            }
        }

        if (countAsterisk >= 1) {
            int cnt = 0;
            for (char c : chars) {
                if (c == '*') {
                    break;
                }
                if (c == ')') {
                    cnt--;
                } else {
                    cnt++;
                }
                if (cnt < 0) {
                    return false;
                }
            }

            cnt = 0;
            for (int i = chars.length - 1; i >= 0; i--) {
                char c = chars[i];
                if (c == '*') {
                    break;
                }
                if (c == '(') {
                    cnt--;
                } else {
                    cnt++;
                }
                if (cnt < 0) {
                    return false;
                }
            }

            return true;
        }

        if (chars.length % 2 != 0) {
            return false;
        }

        int open = 0;
        int close = 0;

        for (char c : chars) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                close++;
            }
        }

        if (open > chars.length / 2 || close > chars.length / 2) {
            return false;
        }

        int cnt = 0;
        for (char c : chars) {
            if (c == '?') {
                if (open < chars.length / 2) {
                    c = '(';
                    open++;
                } else {
                    c = ')';
                }
            }
            if (c == '(') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt < 0) {
                return false;
            }
        }

        return true;
    }
}
