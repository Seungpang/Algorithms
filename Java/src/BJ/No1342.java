package BJ;
// 행운의 문자열

import java.util.Scanner;

public class No1342 {
    static int[] alpha = new int[26];
    static int len, cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        len = s.length();

        for (int i=0; i<len; i++) {
            alpha[s.charAt(i)-'a']++;
        }

        permutation(0, ' ');

        System.out.println(cnt);
    }

    public static void permutation(int depth, char prev) {
        if (depth == len) {
            cnt++;
            return;
        }

        for (int i=0; i<26; i++) {
            if (alpha[i] > 0 && (char)(i+'a') != prev) {
                alpha[i]--;
                permutation(depth+1, (char)(i+'a'));
                alpha[i]++;
            }
        }
    }
}
