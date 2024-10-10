package BJ;
// 배열 돌리기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17276 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int[][] X = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    X[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            d = ((d % 360) + 360) % 360;
            int rotations = d / 45;

            for (int r = 0; r < rotations; r++) {
                X = rotateClockwise45(X);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(X[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private static int[][] rotateClockwise45(int[][] X) {
        int n = X.length;
        int[][] rotated = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[i][j] = X[i][j];
            }
        }

        int mid = n / 2;

        for (int i = 0; i < n; i++) {
            rotated[i][mid] = X[i][i];
        }
        for (int i = 0; i < n; i++) {
            rotated[n - 1 - i][i] = X[i][mid];
        }
        for (int i = 0; i < n; i++) {
            rotated[mid][i] = X[n - 1 - i][i];
        }
        for (int i = 0; i < n; i++) {
            rotated[i][i] = X[mid][i];
        }

        return rotated;
    }
}
