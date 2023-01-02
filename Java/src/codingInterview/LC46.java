package codingInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC46 {

    public static void main(String[] args) {
        final LC46 lc46 = new LC46();
        System.out.println(lc46.permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for (int num : nums) {
            numbers.add(num);
        }
        int n = nums.length;
        backtrack(n, numbers, result, 0);
        return result;
    }

    private void backtrack(final int n, final List<Integer> numbers, final List<List<Integer>> result, final int first) {
        if (first == n) {
            result.add(new ArrayList<>(numbers));
        }

        for (int i = first; i < n; i++) {
            Collections.swap(numbers, first, i);
            backtrack(n, numbers, result, first + 1);
            Collections.swap(numbers, first, i);
        }
    }
}
