package codingInterview;

public class LC704 {

    public static void main(String[] args) {
        final LC704 lc704 = new LC704();
        System.out.println(lc704.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
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
        return -1;
    }
}
