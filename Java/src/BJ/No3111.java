package BJ;
//자료 구조
//검열

import java.util.Scanner;

public class No3111 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String target = sc.nextLine();
        String reversS = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversS += s.charAt(i);
        }

        while (true) {
            if (!target.contains(s)) {
                System.out.println(target);
                break;
            }

            target = target.replaceFirst(s, target);
            if (!target.contains(s)) {
                System.out.println(target);
                break;
            }

        }

    }
}
