package BJ;
// 직각삼각형

import java.util.Scanner;

public class No4153 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        while ((a = sc.nextInt()) != 0) {
            int b = sc.nextInt();
            int c = sc.nextInt();
            int max = Math.max(a, Math.max(b, c));
            int min = Math.min(a, Math.min(b, c));
            int middle;
            if (a != max && a != min) {
                middle = a;
            } else if (b != max && b != min) {
                middle = b;
            } else {
                middle = c;
            }
            if (max * max == min * min + middle * middle) {

                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
