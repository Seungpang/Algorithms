package BJ;
// 피카츄

import java.util.Scanner;

public class No14405 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();

        S = S.replaceAll("pi", " ");
        S = S.replaceAll("ka", " ");
        S = S.replaceAll("chu", " ");
        if (S.trim().length() == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
