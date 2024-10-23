package BJ;
// 체스판 다시 칠하기

import java.util.Scanner;

public class No1018 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                int count = countRepaint(board, i, j);
                minCount = Math.min(minCount, count);
            }
        }

        System.out.println(minCount);
    }

    static int countRepaint(char[][] board, int x, int y) {
        int white = 0;
        int black = 0;
        for (int i = x; i < x + 8; i++) {
            for (int j= y; j < y + 8; j++) {
                char curr = board[i][j];

                if ((i + j) % 2 == 0) {
                    if (curr != 'W') {
                        white++;
                    } else {
                        black++;
                    }
                } else {
                    if (curr != 'B') {
                        white++;
                    } else {
                        black++;
                    }
                }
            }
        }

        return Math.min(white, black);
    }
}
