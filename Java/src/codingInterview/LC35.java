package codingInterview;

public class LC35 {

    public static void main(String[] args) {
        final LC35 lc35 = new LC35();
        System.out.println(lc35.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
