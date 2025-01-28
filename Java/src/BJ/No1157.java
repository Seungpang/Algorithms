package BJ;
// 단어 공부

import java.util.Scanner;

public class No1157 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine().toUpperCase();
        int[] alpha = new int[26];
        for (int i = 0; i < word.length(); i++) {
            alpha[word.charAt(i) - 'A']++;
        }

        char result = '?';
        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (max < alpha[i]) {
                max = alpha[i];
                result = (char) ('A' + i);
            } else if (max == alpha[i]) {
                result = '?';
            }
        }

        System.out.println(result);
    }
}
