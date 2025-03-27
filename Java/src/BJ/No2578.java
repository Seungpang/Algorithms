package BJ;
// 빙고

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2578 {

    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        board = new int[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                count++;

                markNumber(num);

                if (checkBingo() >= 3) {
                    System.out.println(count);
                    return;
                }
            }
        }
    }

    static void markNumber(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == num) {
                    board[i][j] = 0;
                    return;
                }
            }
        }
    }

    static int checkBingo() {
        int count = 0;

        for (int i = 0; i < 5; i++) {
            boolean isBingo = true;
            for (int j = 0; j < 5; j++) {
                if (board[i][j] != 0) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) count++;
        }

        for (int j = 0; j < 5; j++) {
            boolean isBingo = true;
            for (int i = 0; i < 5; i++) {
                if (board[i][j] != 0) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) count++;
        }

        boolean isMainDiagonal = true;
        for (int i = 0; i < 5; i++) {
            if (board[i][i] != 0) {
                isMainDiagonal = false;
                break;
            }
        }
        if (isMainDiagonal) count++;

        boolean isAntiDiagonal = true;
        for (int i = 0; i < 5; i++) {
            if (board[i][4 - i] != 0) {
                isAntiDiagonal = false;
                break;
            }
        }
        if (isAntiDiagonal) count++;

        return count;
    }
}
