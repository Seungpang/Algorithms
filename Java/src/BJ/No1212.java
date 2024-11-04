package BJ;
// 8진수 2진수

import java.util.Scanner;

public class No1212 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toBinaryString(s.charAt(0) - '0'));

        for (int i = 1; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            String segment = Integer.toBinaryString(digit);

            while (segment.length() < 3) {
                segment = "0" + segment;
            }

            sb.append(segment);
        }

        System.out.println(sb);
    }
}
