package codingInterview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC760 {

    public static void main(String[] args) {
        final LC760 lc760 = new LC760();
        System.out.println(
                Arrays.toString(lc760.anagramMappings(new int[]{12, 28, 46, 32, 50}, new int[]{50, 12, 32, 46, 28})));
        //[1,4,3,2,0]
    }

    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums1.length;

        for (int i=0; i<n; i++) {
            map.put(nums2[i], i);
        }

        int[] result = new int[n];
        for (int i=0; i<n; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}
