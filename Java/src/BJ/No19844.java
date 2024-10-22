package BJ;
// 단어 개수 세기

import java.util.Scanner;

public class No19844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String[] words = sentence.split("[\\s-]+");

        int wordCount = 0;
        String[] prefixes = {"c'", "j'", "n'", "m'", "t'", "s'", "l'", "d'", "qu'"};
        String vowels = "aeiouh";
        for (String word : words) {
            boolean split = false;
            for (String prefix : prefixes) {
                if (word.startsWith(prefix) && word.length() > prefix.length()) {
                    char nextChar = word.charAt(prefix.length());
                    if (vowels.indexOf(nextChar) >= 0) {
                        wordCount += 2;
                        split = true;
                        break;
                    }
                }
            }

            if (!split) {
                wordCount += 1;
            }
        }

        System.out.println(wordCount);
    }
}
