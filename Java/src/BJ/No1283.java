package BJ;
// 단축키 지정

import java.util.Scanner;

public class No1283 {

    static boolean[] used =  new boolean[26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String s = sc.nextLine();
            int pick = pickIndex(s);

            if (pick == -1) {
                sb.append(s).append("\n");
            } else {
                char c = s.charAt(pick);
                used[idx(c)] = true;

                StringBuilder line = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    if (i == pick) {
                        line.append('[').append(s.charAt(i)).append(']');
                    } else {
                        line.append(s.charAt(i));
                    }
                }
                sb.append(line).append("\n");
            }
        }
        System.out.println(sb);
    }

    static int pickIndex(String s) {
        int n =  s.length();
        for (int i = 0; i < n; i++) {
            if (isWordStart(s, i) && isAlpha(s.charAt(i)) && !used[idx(s.charAt(i))]) {
                return i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (isAlpha(s.charAt(i)) && !used[idx(s.charAt(i))]) {
                return i;
            }
        }

        return -1;
    }

    static boolean isWordStart(String s, int i) {
        return i == 0 || s.charAt(i - 1) == ' ';
    }

    static boolean isAlpha(char c) {
        char lc = Character.toLowerCase(c);
        return lc >= 'a' && lc <= 'z';
    }

    static int idx(char c) {
        return Character.toLowerCase(c) - 'a';
    }
}
