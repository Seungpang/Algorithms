package BJ;
// 삼각형 외우기

import java.util.Scanner;

public class No10101 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        if (a == 60 && b == 60 && c == 60) {
            System.out.println("Equilateral");
        } else if (a + b + c == 180 && ((a == b) || (b == c) || (c == a))) {
            System.out.println("Isosceles");
        } else if (a+b+c == 180 && a != b && b != c && a != c) {
            System.out.println("Scalene");
        } else {
            System.out.println("Error");
        }
    }
}
