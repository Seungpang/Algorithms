package BJ;
// 222-풀링

import java.util.Arrays;
import java.util.Scanner;

public class No17829 {

    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        System.out.println(go(0, 0, n));
    }

    static int go(int r, int c, int size) {
        int[] arr = new int[4];
        if (size == 2) {
            int idx = 0;
            for (int i = r; i < r + 2; i++) {
                for (int j = c; j < c + 2; j++) {
                    arr[idx++] = map[i][j];
                }
            }
        } else {
            size = size / 2;
            arr[0] = go(r, c, size);
            arr[1] = go(r, c + size, size);
            arr[2] = go(r + size, c, size);
            arr[3] = go(r + size, c + size, size);
        }
        Arrays.sort(arr);
        return arr[2];
    }
}
