package BJ;
// 과제 안 내신 분..?

import java.util.Scanner;

public class No5597 {

    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        boolean[] students = new boolean[31];

        for (int i = 0; i < 28; i++) {
            int n = sc.nextInt();
            students[n] = true;
        }

        for (int i = 1; i <= 30; i++) {
            if (!students[i]) {
                System.out.println(i);
            }
        }
    }
}
