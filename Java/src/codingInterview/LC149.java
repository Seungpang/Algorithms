package codingInterview;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LC149 {

    public static void main(String[] args) {
        final LC149 lc149 = new LC149();
        System.out.println(lc149.maxPoints(new int[][]{
                {1, 1}, {2, 2}, {3, 3}
        }));
    }

    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 1) {
            return 1;
        }
        int result = 2;
        for (int i = 0; i < n; i++) {
            Map<Double, Integer> cnt = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    cnt.merge(Math.atan2(points[j][1] - points[i][1], points[j][0] - points[i][0]), 1, Integer::sum);
                }
            }
            result = Math.max(result, Collections.max(cnt.values()) + 1);
        }
        return result;
    }
}
