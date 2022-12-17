package codingInterview;

public class LC209 {

    public static void main(String[] args) {
        final LC209 lc209 = new LC209();
        System.out.println(lc209.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int result = Integer.MAX_VALUE;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                result = Math.min(result, i - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
