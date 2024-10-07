package BJ;
// 2x2x2 큐브

import java.util.Scanner;

public class No16939 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] cube = new int[25];
        for (int i = 1; i <= 24; i++) {
            cube[i] = sc.nextInt();
        }

        if (tryRotate(cube)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        sc.close();
    }

    public static boolean tryRotate(int[] cube) {
        int[][][] rotations = {
                // 회전 1
                {{1, 24}, {3, 22}, {5, 1}, {7, 3}, {9, 5}, {11, 7}, {22, 11}, {24, 9}},
                // 회전 2
                {{2, 23}, {4, 21}, {6, 2}, {8, 4}, {10, 6}, {12, 8}, {21, 12}, {23, 10}},
                // 회전 3
                {{13, 21}, {14, 22}, {5, 13}, {6, 14}, {17, 5}, {18, 6}, {21, 17}, {22, 18}},
                // 회전 4
                {{15, 23}, {16, 24}, {7, 15}, {8, 16}, {19, 7}, {20, 8}, {23, 19}, {24, 20}},
                // 회전 5
                {{3, 16}, {4, 14}, {17, 3}, {19, 4}, {10, 17}, {9, 19}, {16, 10}, {14, 9}},
                // 회전 6
                {{1, 15}, {2, 13}, {18, 1}, {20, 2}, {11, 18}, {12, 20}, {13, 11}, {15, 12}}
        };

        for (int[][] currentRotation : rotations) {
            rotate(cube, currentRotation);
            if (isSolved(cube)) {
                return true;
            }
            rotate(cube, currentRotation);
            rotate(cube, currentRotation);
            rotate(cube, currentRotation);
        }

        for (int[][] currentRotation : rotations) {
            rotate(cube, currentRotation);
            rotate(cube, currentRotation);
            rotate(cube, currentRotation);
            if (isSolved(cube)) {
                return true;
            }
            rotate(cube, currentRotation);
        }

        return false;
    }

    public static void rotate(int[] cube, int[][] rotations) {
        int[] temp = cube.clone();
        for (int[] rotation : rotations) {
            cube[rotation[1]] = temp[rotation[0]];
        }
    }

    public static boolean isSolved(int[] cube) {
        for (int i = 1; i <= 24; i += 4) {
            int color = cube[i];
            for (int j = i; j < i + 4; j++) {
                if (cube[j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
