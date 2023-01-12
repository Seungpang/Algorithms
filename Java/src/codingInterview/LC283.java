package codingInterview;

import java.util.Arrays;

public class LC283 {

    public static void main(String[] args) {
        final LC283 lc283 = new LC283();
        System.out.println(Arrays.toString(lc283.moveZeroes(new int[]{0, 1, 0, 3, 12})));
    }

    public int[] moveZeroes(int[] nums) {
        for (int foundZeroIndex = 0, curr = 0; curr < nums.length; curr++) {
            if (nums[curr] != 0) {
                swap(nums, foundZeroIndex++, curr);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
