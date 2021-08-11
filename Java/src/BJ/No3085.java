package BJ;

import java.util.Scanner;

public class No3085 {

    static int check(char[][] board) {
        int n = board.length;
        int ans = 1;
        for (int i=0; i<n; i++) {
            int cnt = 1;
            for (int j=1; j<n; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (ans < cnt) ans = cnt;
            }
            cnt = 1;
            for (int j=1; j<n; j++) {
                if (board[j][i] == board[j-1][i]) {
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (ans < cnt) ans = cnt;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] board = new char[n][n];

        for (int i=0; i<n; i++) {
            board[i] = sc.next().toCharArray();
        }

        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (j+1 < n) {
                    char t = board[i][j]; board[i][j] = board[i][j+1]; board[i][j+1] = t;
                    int temp = check(board);
                    if (ans < temp) ans = temp;
                    t = board[i][j]; board[i][j] = board[i][j+1]; board[i][j+1] = t;
                }
                if (i+1 < n) {
                    char t = board[i][j]; board[i][j] = board[i+1][j]; board[i+1][j] = t;
                    int temp = check(board);
                    if (ans < temp) ans = temp;
                    t = board[i][j]; board[i][j] = board[i+1][j]; board[i+1][j] = t;
                }
            }
        }
        System.out.println(ans);
    }

}
