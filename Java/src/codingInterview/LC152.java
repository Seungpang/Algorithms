package codingInterview;

public class LC152 {

    public static void main(String[] args) {
        final LC152 lc152 = new LC152();
        System.out.println(lc152.maxProduct1(new int[]{2, 3, -2, 4}));
        System.out.println(lc152.maxProduct2(new int[]{2, 3, -2, 4}));
    }

    public int maxProduct1(int[] nums) {
        if (nums.length == 0) return 0;

        int result = nums[0];
        for (int i=0; i<nums.length; i++) {
            int accu = 1;
            for (int j=i; j<nums.length; j++) {
                accu *= nums[j];
                result = Math.max(accu, result);
            }
        }
        return result;
    }

    public int maxProduct2(int[] nums) {
        if (nums.length == 0) return 0;

        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int temp = Math.max(curr, Math.max(max * curr, min * curr));
            min = Math.min(curr, Math.min(max * curr, min * curr));

            max = temp;
            result = Math.max(max, result);
        }
        return result;
    }
}
