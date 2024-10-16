package BJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class No5618 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        int gcd = numbers[0];
        for (int i = 1; i < n; i++) {
            gcd = getGCD(gcd, numbers[i]);
        }

        List<Integer> commonDivisors = new ArrayList<>();
        for (int i = 1; i <= gcd; i++) {
            if (gcd % i == 0) {
                commonDivisors.add(i);
            }
        }

        Collections.sort(commonDivisors);

        for (int divisor : commonDivisors) {
            System.out.println(divisor);
        }
    }

    static int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
