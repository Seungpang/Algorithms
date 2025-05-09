package BJ;
// 스도쿠

import java.util.Scanner;

public class No2239 {

    static final int SIZE = 9;

    static int[][] board = new int[SIZE][SIZE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < SIZE; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        if (isSudoku()) {
            printBoard();
        }
    }

    static boolean isSudoku() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (board[r][c] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(r, c, num)) {
                            board[r][c] = num;
                            if (isSudoku()) {
                                return true;
                            } else {
                                board[r][c] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isValid(int r, int c, int num) {
        for (int x = 0; x < SIZE; x++) {
            if (board[r][x] == num) {
                return false;
            }
        }

        for (int x = 0; x < SIZE; x++) {
            if (board[x][c] == num) {
                return false;
            }
        }

        int startRow = r - r % 3;
        int startCol = c - c % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j+startCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    static void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
