package BJ;
//나는 친구가 적다 (Small)

import java.util.Scanner;

public class No16171 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String K = sc.nextLine();

        String cleanedS = S.replaceAll("[0-9]", "");

        int result = cleanedS.contains(K) ? 1 : 0;

        System.out.println(result);
    }
}
