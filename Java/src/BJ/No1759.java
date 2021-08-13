package BJ;

import java.util.Arrays;
import java.util.Scanner;

public class No1759 {

    public static boolean check(String password) {
        int ja = 0;
        int mo = 0;
        for (char c : password.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c=='u') {
                mo += 1;
            } else {
                ja += 1;
            }
        }
        return ja >= 2 && mo >= 1;
    }

    public static void go(int l, String[] alpha, String password, int i) {
        if (password.length() == l) {
            if (check(password)) {
                System.out.println(password);
            }
            return;
        }
        if (i >= alpha.length) return;
        go(l, alpha, password + alpha[i], i + 1);
        go(l, alpha, password, i + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int c = sc.nextInt();

        String[] alpha = new String[c];
        for (int i=0; i<c; i++) {
            alpha[i] = sc.next();
        }

        Arrays.sort(alpha);
        go(l, alpha, "", 0);
    }
}
