package BJ;
// 달팽이

import java.util.Scanner;

public class No1913 {

    static int[][] board;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int target = sc.nextInt();
        board = new int[n][n];

        int targetX = 0;
        int targetY = 0;

        makeBoard(n);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]).append(" ");
                if (board[i][j] == target) {
                    targetX = i;
                    targetY = j;
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
        System.out.println((targetX+1) + " " + (targetY+1));
    }

    public static void makeBoard(int n) {
        int r = 0;
        int c = 0;
        int count = n*n;
        int direct = 0;

        while (count != 0) {
            board[r][c] = count--;
            int dr = r + dirs[direct][0];
            int dc = c + dirs[direct][1];
            if (dr >= n || dc >= n || dr < 0 || dc < 0 || board[dr][dc] != 0) {
                direct = (direct + 1) % 4;
            }
            r = r + dirs[direct][0];
            c = c + dirs[direct][1];
        }
    }
}
