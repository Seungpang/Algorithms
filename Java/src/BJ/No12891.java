package BJ;
// DNA 비밀번호

import java.util.Scanner;

public class No12891 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int P = sc.nextInt();
        sc.nextLine();
        String dna = sc.nextLine();
        int a = sc.nextInt();
        int c = sc.nextInt();
        int g = sc.nextInt();
        int t = sc.nextInt();

        System.out.println(countValidPasswords(dna, P, a, c, g, t));
    }

    static int countValidPasswords(String dna, int p, int a, int c, int g, int t) {
        int count = 0;
        int[] window = new int[26];

        for (int i = 0; i < p; i++) {
            window[dna.charAt(i) - 'A']++;
        }

        if (isValidPassword(a, c, g, t, window)) {
            count++;
        }

        for (int i=p; i<dna.length(); i++) {
            window[dna.charAt(i - p) - 'A']--;
            window[dna.charAt(i) - 'A']++;

            if (isValidPassword(a, c, g, t, window)) {
                count++;
            }
        }

        return count;
    }

    private static boolean isValidPassword(final int a, final int c, final int g, final int t, final int[] window) {
        return window['A' - 'A'] >= a && window['C' - 'A'] >= c &&
                window['G' - 'A'] >= g && window['T' - 'A'] >= t;
    }
}
