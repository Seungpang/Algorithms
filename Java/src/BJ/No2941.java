package BJ;
// 크로아티아 알파벳

import java.util.Scanner;

public class No2941 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String[] croatian = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (String alpha : croatian) {
            s = s.replace(alpha, "X");
        }

        System.out.println(s.length());
    }
}
