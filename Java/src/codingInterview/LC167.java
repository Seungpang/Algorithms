package codingInterview;

import java.util.Arrays;

public class LC167 {

    public static void main(String[] args) {
        final LC167 lc167 = new LC167();
        System.out.println(Arrays.toString(lc167.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[]{-1, -1};
    }
}
