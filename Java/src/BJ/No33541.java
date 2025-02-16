package BJ;
// 2025는 무엇이 특별할까?

import java.util.Scanner;

public class No33541 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt() + 1;

        while (year <= 9999) {
            int a = year / 100;
            int b = year % 100;
            int sum = a + b;

            if (year == sum * sum) {
                System.out.println(year);
                return;
            }

            year++;
        }

        System.out.println(-1);
    }
}
