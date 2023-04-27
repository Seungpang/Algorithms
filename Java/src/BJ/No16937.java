package BJ;
// 두 스티커

import java.util.Scanner;

public class No16937 {
    static int h, w;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        h = sc.nextInt();
        w = sc.nextInt();
        int n = sc.nextInt();
        int[][] stickers = new int[n][3];
        for (int i = 0; i < n; i++) {
            stickers[i][0] = sc.nextInt();
            stickers[i][1] = sc.nextInt();
            stickers[i][2] = stickers[i][0] * stickers[i][1];
        }
        System.out.println(calculateMaxArea(stickers));
    }

    public static int calculateMaxArea(int[][] stickers) {
        int area = 0;
        for (int i = 0; i < stickers.length; i++) {
            for (int j = i + 1; j < stickers.length; j++) {
                if (pastable(stickers[i], stickers[j])) {
                    area = Math.max(area, stickers[i][2] + stickers[j][2]);
                }
            }
        }
        return area;
    }

    public static boolean pastable(int[] a, int[] b) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if ((a[i] + b[j]) <= h && Math.max(a[(i + 1) % 2], b[(j + 1) % 2]) <= w) {
                    return true;
                }
                if ((a[i] + b[j]) <= w && Math.max(a[(i + 1) % 2], b[(j + 1) % 2]) <= h) {
                    return true;
                }
            }
        }
        return false;
    }
}
