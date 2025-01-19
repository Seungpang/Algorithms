package BJ;
// 복호화

import java.util.Scanner;

public class No9046 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T  = sc.nextInt();
        sc.nextLine();
        while (T-- > 0) {
            String s = sc.nextLine();
            int[] alpha = new int[26];
            for (char c : s.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    alpha[c - 'a']++;
                }
            }

            int maxFreq = 0;
            for (int freq : alpha) {
                maxFreq = Math.max(maxFreq, freq);
            }

            char result = '?';
            int count = 0;
            for (int i = 0; i < 26; i++) {
                if (alpha[i] == maxFreq) {
                    result = (char) ('a' + i);
                    count++;
                    if (count > 1) {
                        result = '?';
                        break;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
