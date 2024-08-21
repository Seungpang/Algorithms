package BJ;
// 다각형 게임

import java.util.Scanner;

public class No13034 {

    private static final int MAX_N = 1000;
    private static int[] grundyNumbers = new int[MAX_N + 1];

    public static void main(String[] args) {
        calculateGrundyNumbers();

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(findWinner(N));
    }

    public static void calculateGrundyNumbers() {
        grundyNumbers[0] = 0;
        grundyNumbers[1] = 0;
        grundyNumbers[2] = 1;

        for (int i = 3; i <= MAX_N; i++) {
            boolean[] mex = new boolean[MAX_N + 1];
            for (int j = 0; j <= i / 2; j++) {
                int left = j;
                int right = (i - 2) - j;
                mex[grundyNumbers[left] ^ grundyNumbers[right]] = true;
            }

            for (int k = 0; k <= i; k++) {
                if (!mex[k]) {
                    grundyNumbers[i] = k;
                    break;
                }
            }
        }
    }

    private static int findWinner(int N) {
        return (grundyNumbers[N] == 0) ? 2 : 1;
    }
}
