package BJ;

import java.util.Scanner;
// 단어 나누기

public class No1251 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int len = s.length();
        String result = null;
        for (int i = 1; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                String part1 = s.substring(0, i);
                String part2 = s.substring(i, j);
                String part3 = s.substring(j);

                String reversed1 = new StringBuilder(part1).reverse().toString();
                String reversed2 = new StringBuilder(part2).reverse().toString();
                String reversed3 = new StringBuilder(part3).reverse().toString();

                String combined = reversed1 + reversed2 + reversed3;
                if (result == null || combined.compareTo(result) < 0) {
                    result = combined;
                }
            }
        }

        System.out.println(result);
    }
}
