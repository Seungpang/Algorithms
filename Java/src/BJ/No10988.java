package BJ;
// 팰린드롬인지 확인하기

import java.util.Scanner;

public class No10988 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        System.out.println(isPalindrome(word));
    }

    private static int isPalindrome(String word) {
        int n = word.length();
        for (int i = 0; i < n / 2; i++) {
            if (word.charAt(i) != word.charAt(n - i - 1)) {
                return 0;
            }
        }
        return 1;
    }
}
