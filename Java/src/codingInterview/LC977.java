package codingInterview;

import java.util.Arrays;

public class LC977 {

    public static void main(String[] args) {
        final LC977 lc977 = new LC977();
        System.out.println(Arrays.toString(lc977.sortedSquares1(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(lc977.sortedSquares2(new int[]{-4, -1, 0, 3, 10})));

    }

    //TC: O(nlogn) Java의 정렬알고리즘 사용해서 SC: O(N)
    public int[] sortedSquares1(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = nums[i] * nums[i];
        }
        Arrays.sort(result);

        return result;
    }

    //TC: O(N)  SC: O(N)
    public int[] sortedSquares2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int square;
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                square = nums[right];
                right--;
            } else {
                square = nums[left];
                left++;
            }
            result[i] = square * square;
        }

        return result;
    }
}
