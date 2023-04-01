package BJ;

import java.util.Scanner;

public class No1629 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(recur(a, b, c));
    }

    public static long recur(int a, int b, int c) {
        if (b == 1) {
            return a % c;
        }
        long value = recur(a, b / 2, c);
        value = value * value % c;
        if (b % 2 == 0) return value;
        return value * a % c;
    }
}
