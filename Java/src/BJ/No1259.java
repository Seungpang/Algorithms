package BJ;
// 팰린드롬수

import java.util.Scanner;

public class No1259 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String num = sc.nextLine();
            if (num.equals("0")) {
                break;
            }

            if (isPalindrome(num)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    static boolean isPalindrome(String num) {
        int len = num.length();
        for (int i = 0; i < len; i++) {
            if (num.charAt(i) != num.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
