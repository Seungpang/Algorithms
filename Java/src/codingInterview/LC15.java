package codingInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC15 {

    public static void main(String[] args) {
        final LC15 lc15 = new LC15();
        System.out.println(lc15.threeSum1(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(lc15.threeSum2(new int[]{-1, 0, 1, 2, -1, -4}));
        //System.out.println(lc15.threeSum3(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                int low = i+1;
                int high = nums.length-1;
                while (low < high) {
                    int sum = nums[i] + nums[low] + nums[high];
                    if (sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[low++], nums[high--]));
                        while (low < high && nums[low] == nums[low - 1]) {
                            low++;
                        }
                    } else if (sum < 0) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (dups.add(nums[i])) {
                for (int j = i + 1; j < nums.length; j++) {
                    int complement = -nums[i] - nums[j];
                    if (map.containsKey(complement) && map.get(complement) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        result.add(triplet);
                    }
                    map.put(nums[j], i);
                }
            }
        }
        return new ArrayList<>(result);
    }
}
