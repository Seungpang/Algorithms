package BJ;
// 팰린드롬 척화비

import java.util.Scanner;

public class No20944 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < N / 2; i++) {
            result.append('a');
        }

        if (N % 2 != 0) {
            result.append('a');
        }

        result.append(result, 0, N / 2);

        System.out.println(result);
    }
}
