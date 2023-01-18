package codingInterview;

import java.util.Arrays;

public class LC733 {

    public static void main(String[] args) {
        final LC733 lc733 = new LC733();
        System.out.println(Arrays.deepToString(lc733.floodFill(new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        }, 1, 1, 2)));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int imageColor = image[sr][sc];
        if (imageColor != color) {
            dfs(image, sr, sc, imageColor, color);
        }
        return image;
    }

    private void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) {
                dfs(image, r - 1, c, color, newColor);
            }
            if (c >= 1) {
                dfs(image, r, c - 1, color, newColor);
            }
            if (r + 1 < image.length) {
                dfs(image,r+1, c, color, newColor);
            }
            if (c + 1 < image[0].length) {
                dfs(image, r, c + 1, color, newColor);
            }
        }

    }
}
