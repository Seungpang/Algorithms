package BJ;
// 잠수함 식별

import java.util.Scanner;
import java.util.regex.Pattern;

public class No2671 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String regex = "(100+1+|01)+";

        if (Pattern.matches(regex, s)) {
            System.out.println("SUBMARINE");
        } else {
            System.out.println("NOISE");
        }
    }
}
