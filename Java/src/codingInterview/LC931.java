package codingInterview;

public class LC931 {

    public static void main(String[] args) {
        final LC931 lc931 = new LC931();
        System.out.println(lc931.minFallingPathSum(
                new int[][]{
                        {2, 1, 3},
                        {6, 5, 4},
                        {7, 8, 9}
                }
        ));
    }

    public int minFallingPathSum(int[][] matrix) {
        int minSum = 0;
        int n = matrix.length;
        for (int i=0; i<n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j=0; j<n; j++) {
                min = Math.min(min, matrix[i][j]);
                System.out.println(min);
            }
            minSum += min;
        }
        return minSum;
    }
}
