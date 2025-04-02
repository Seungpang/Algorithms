package BJ;
// 블로그2

import java.util.Scanner;

public class No20365 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();

        int countB = 0;
        int countR = 0;

        boolean lastWasB = false;
        boolean lastWasR = false;

        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == 'B') {
                if (!lastWasB) {
                    countB++;
                    lastWasB = true;
                    lastWasR = false;
                }
            } else { // 'R'
                if (!lastWasR) {
                    countR++;
                    lastWasR = true;
                    lastWasB = false;
                }
            }
        }

        int result = Math.min(countR + 1, countB + 1);

        System.out.println(result);
    }
}
