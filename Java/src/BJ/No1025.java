package BJ;
// 제곱수 찾기

import java.util.Scanner;

public class No1025 {

    static int N, M;
    static int[][] map;
    static int maxSquare = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int num = map[i][j];
                int sqrt = (int) Math.sqrt(num);
                if (sqrt * sqrt == num && num > maxSquare) {
                    maxSquare = num;
                }
            }
        }

        for (int rStart = 0; rStart < N; rStart++) {
            for (int cStart = 0; cStart < M; cStart++) {
                for (int rDiff = -N + 1; rDiff < N; rDiff++) {
                    for (int cDiff = -M + 1; cDiff < M; cDiff++) {
                        if (rDiff == 0 && cDiff == 0) continue;
                        checkSequence(rStart, cStart, rDiff, cDiff);
                    }
                }
            }
        }

        System.out.println(maxSquare);
    }

    static void checkSequence(int rStart, int cStart, int rDiff, int cDiff) {
        StringBuilder sb = new StringBuilder();
        int r = rStart, c = cStart;
        int count = 0;
        while (r >= 0 && r < N && c >= 0 && c < M) {
            sb.append(map[r][c]);
            count++;
            if (count > 1) {
                int num = Integer.parseInt(sb.toString());
                int sqrt = (int) Math.sqrt(num);
                if (sqrt * sqrt == num && num > maxSquare) {
                    maxSquare = num;
                }
            }
            r += rDiff;
            c += cDiff;
        }
    }
}
