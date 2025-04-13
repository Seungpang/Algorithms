package BJ;
// 붐버맨

import java.util.Arrays;
import java.util.Scanner;

public class No16918 {

    static char[][] grid;
    static int R, C, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        N = sc.nextInt();
        sc.nextLine();

        grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            grid[i] = sc.nextLine().toCharArray();
        }

        if (N <= 1) {
            printGrid();
            return;
        }

        if (N % 2 == 0) {
            fillGrid();
        } else {
            int cycleLength = 4;
            int effectiveN = ((N - 1) % cycleLength) + 1;

            if (effectiveN == 3) {
                simulateExplosion();
            } else {
                simulateExplosion();
                simulateExplosion();
            }
        }

        printGrid();
    }

    static void fillGrid() {
        for (int i = 0; i < R; i++) {
            Arrays.fill(grid[i], 'O');
        }
    }

    static void simulateExplosion() {
        char[][] newGrid = new char[R][C];
        for (char[] row : newGrid) {
            Arrays.fill(row, 'O');
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 'O') {
                    newGrid[i][j] = '.';
                    if (i > 0) newGrid[i-1][j] = '.';
                    if (i < R-1) newGrid[i+1][j] = '.';
                    if (j > 0) newGrid[i][j-1] = '.';
                    if (j < C-1) newGrid[i][j+1] = '.';
                }
            }
        }

        grid = newGrid;
    }

    static void printGrid() {
        for (char[] row : grid) {
            System.out.println(new String(row));
        }
    }
}
