package BJ;
// 별 찍기 - 10

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2447 {
    static char[][] pattern;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        pattern = new char[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                pattern[i][j] = ' ';
            }
        }

        makePattern(0, 0, N);
        for (int i = 0; i < N; i++) {
            System.out.println(pattern[i]);
        }
    }

    static void makePattern(int row, int col, int size) {
        if (size == 1) {
            pattern[row][col] = '*';
            return;
        }

        int newSize = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) {
                    makePattern(row + i * newSize, col + j * newSize, newSize);
                }
            }
        }
    }
}
