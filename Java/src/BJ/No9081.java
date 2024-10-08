package BJ;
// 단어 맞추기

import java.util.Scanner;

public class No9081 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        while (T-- > 0) {
            char[] word = sc.nextLine().toCharArray();
            if (nextPermutation(word)) {
                System.out.println(new String(word));
            } else {
                System.out.println(new String(word));
            }
        }
    }

    static boolean nextPermutation(char[] word) {
        int i = word.length - 2;
        while (i >= 0 && word[i] >= word[i + 1]) i--;
        if (i < 0) return false;

        int j = word.length - 1;
        while (word[j] <= word[i]) j--;
        char temp = word[i];
        word[i] = word[j];
        word[j] = temp;
        reverse(word, i + 1, word.length - 1);
        return true;
    }

     static void reverse(char[] word, int start, int end) {
        while (start < end) {
            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;
            start++;
            end--;
        }
    }
}
