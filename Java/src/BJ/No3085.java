package BJ;
// 사탕 게임

import java.util.Scanner;

public class No3085 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            board[i] = sc.next().toCharArray();
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n) {
                    swap(j, board[i]);
                    ans = Math.max(check(board), ans);
                    swap(j, board[i]);
                }
                if (i + 1 < n) {
                    swap(board, i, j);
                    ans = Math.max(check(board), ans);
                    swap(board, i, j);
                }
            }
        }
        System.out.println(ans);
    }

    private static void swap(int j, char[] board) {
        char t = board[j];
        board[j] = board[j + 1];
        board[j + 1] = t;
    }

    private static void swap(char[][] board, int i, int j) {
        char t = board[i][j];
        board[i][j] = board[i + 1][j];
        board[i + 1][j] = t;
    }

    private static int check(char[][] board) {
        int n = board.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                ans = Math.max(ans, cnt);
            }
            cnt = 1;
            for (int j = 1; j < n; j++) {
                if (board[j][i] == board[j - 1][i]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}
