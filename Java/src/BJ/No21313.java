package BJ;
// 문어

import java.util.Scanner;

public class No21313 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] sequence = new int[N];

        sequence[0] = 1;

        for (int i = 1; i < N - 1; i++) {
            if (sequence[i - 1] != 1) {
                sequence[i] = 1;
            } else {
                sequence[i] = 2;
            }
        }

        for (int k = 1; k <= 8; k++) {
            if (k != sequence[N - 2] && k != sequence[0]) {
                sequence[N - 1] = k;
                break;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(sequence[i]);
            if (i != N - 1) {
                System.out.print(" ");
            }
        }
    }
}
