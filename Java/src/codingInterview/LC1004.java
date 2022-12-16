package codingInterview;

public class LC1004 {

    public static void main(String[] args) {
        final LC1004 lc1004 = new LC1004();
        System.out.println(lc1004.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0}, 1));
    }

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right;
        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                k--;
            }
            if (k < 0 && nums[left++] == 0) {
                k++;
            }
        }
        return right - left;
    }
}
