package codingInterview;

import java.util.Arrays;
import java.util.Comparator;

public class LC452 {

    public static void main(String[] args) {
        final LC452 lc452 = new LC452();
        System.out.println(lc452.findMinArrowShots(new int[][]{
                {10, 16},
                {2, 8},
                {1, 6},
                {7, 12}
        }));
    }

    // 정렬을 사용해서 TC: O(nlogn) SC: O(logn)
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        int arrows = 1;
        int xStart;
        int xEnd;
        int firstEnd = points[0][1];
        for (int[] point : points) {
            xStart = point[0];
            xEnd = point[1];
            if (firstEnd < xStart) {
                arrows++;
                firstEnd = xEnd;
            }
        }
        return arrows;
    }
}
