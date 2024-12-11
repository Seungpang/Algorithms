package BJ;
// 최대공약수 하나 빼기

import java.util.Scanner;

public class No14476 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        int[] leftGcd = new int[N];
        int[] rightGcd = new int[N];

        leftGcd[0] = numbers[0];
        for (int i=1; i < N; i++) {
            leftGcd[i] = gcd(leftGcd[i - 1], numbers[i]);
        }

        rightGcd[N-1] = numbers[N-1];
        for (int i = N - 2; i >= 0; i--) {
            rightGcd[i] = gcd(rightGcd[i + 1], numbers[i]);
        }

        int maxGcd = 0;
        int excludeNumber = -1;

        for (int i = 0; i < N; i++) {
            int currGcd;
            if (i == 0) {
                currGcd = rightGcd[1];
            } else if (i == N - 1) {
                currGcd = leftGcd[N - 2];
            } else {
                currGcd = gcd(leftGcd[i - 1], rightGcd[i + 1]);
            }

            if (numbers[i] % currGcd != 0 && currGcd > maxGcd) {
                maxGcd = currGcd;
                excludeNumber = numbers[i];
            }
        }

        if (excludeNumber == -1) {
            System.out.println(-1);
        } else {
            System.out.println(maxGcd + " " + excludeNumber);
        }

    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
