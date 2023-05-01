package BJ;
// 팰린드롬 만들기

import java.util.Scanner;

public class No1213 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int[] alpha = new int[26];

        for (int i = 0; i < name.length(); i++) {
            alpha[name.charAt(i) - 'A']++;
        }

        int mid = 0;
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (alpha[i] % 2 == 1) {
                mid = i;
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (name.length() % 2 == 1 && count > 1 || name.length() % 2 == 0 && count > 0) {
            sb.append("I'm Sorry Hansoo");
        } else {
            String s = "";
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < alpha[i] / 2; j++) {
                    s += (char) (i + 'A');
                }
            }

            String reverse = new StringBuilder(s).reverse().toString();
            if (count == 1) {
                s += (char) (mid + 'A');
            }
            sb.append(s).append(reverse);
        }
        System.out.println(sb);
    }
}
