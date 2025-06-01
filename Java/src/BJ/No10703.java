package BJ;
// 유성

import java.util.Arrays;
import java.util.Scanner;

public class No10703 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int S = sc.nextInt();
        char[][] map = new char[R][S];
        char[][] result = new char[R][S];
        sc.nextLine();

        for (int i = 0; i < R; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            result[i] = Arrays.copyOf(map[i], S);
            for (int j = 0; j < S; j++) {
                if (map[i][j] == 'X') {
                    result[i][j] = '.';
                }
            }
        }

        int minDist = R;
        for (int col = 0; col < S; col++) {
            int meteorBottom = -1;
            int groudTop = R;
            for (int row = 0; row < R; row++) {
                if (map[row][col] == 'X') {
                    meteorBottom = row;
                } else if (map[row][col] == '#' && meteorBottom != -1) {
                    groudTop = Math.min(groudTop, row);
                    break;
                }
            }

            if (meteorBottom != -1 && groudTop != R) {
                minDist = Math.min(minDist, groudTop - meteorBottom - 1);
            }
        }

        for (int row = R - 1; row >= 0; row--) {
            for (int col = 0; col < S; col++) {
                if (map[row][col] == 'X') {
                    result[row + minDist][col] = 'X';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }
}
