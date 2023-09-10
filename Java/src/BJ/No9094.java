package BJ;
// 수학적 호기심

import java.util.Scanner;

public class No9094 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int count = 0;

            for (int a = 1; a < n; a++) {
                for (int b = a + 1; b < n; b++) {
                    if ((a * a + b * b + m) % (a * b) == 0) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
