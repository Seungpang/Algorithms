package BJ;
// Game Addiction

import java.util.Scanner;

public class No20152 {

    // dp를 이용한 방법
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int H = scanner.nextInt();
//        int N = scanner.nextInt();
//
//        int size = Math.max(H, N) + 1;
//        long[][] dp = new long[size][size];
//
//        dp[H][H] = 1;
//
//        int rowStep = H <= N ? 1 : -1;
//        int colStep = H <= N ? 1 : -1;
//
//        for (int i = H; i != N + rowStep; i += rowStep) {
//            for (int j = H; j != N + colStep; j += colStep) {
//                if (i != H || j != H) {
//                    if (j <= i) {
//                        if (i != H) {
//                            dp[i][j] += dp[i - rowStep][j];
//                        }
//                        if (j != H) {
//                            dp[i][j] += dp[i][j - colStep];
//                        }
//                    }
//                }
//            }
//        }
//
//        System.out.println(dp[N][N]);
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int N = scanner.nextInt();
        scanner.close();

        if (H == N) {
            System.out.println(1);
            return;
        }

        int n = Math.abs(H - N);

        long result = calculateCombination(2 * n, n) - calculateCombination(2 * n, n - 1);

        System.out.println(result);
    }

    private static long calculateCombination(int n, int k) {
        long result = 1;
        for (int i = 1; i <= k; i++) {
            result = result * (n - k + i) / i;
        }
        return result;
    }
}
