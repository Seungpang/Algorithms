package codingInterview;

import java.util.Arrays;

public class LC832 {

    public static void main(String[] args) {
        final LC832 lc832 = new LC832();
        System.out.println(Arrays.deepToString(lc832.flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}})));
    }

    public int[][] flipAndInvertImage(int[][] image) {
        int n = image[0].length;
        for (int[] a : image) {
            for (int i = 0; i < (n + 1) / 2; i++) {
                int temp = a[i] ^ 1;
                a[i] = a[n-1-i] ^ 1;
                a[n - 1 - i] = temp;
            }
        }
        return image;
    }
}
