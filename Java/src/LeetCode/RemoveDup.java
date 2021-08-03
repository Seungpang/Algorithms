package LeetCode;

public class RemoveDup {
    public static void main(String[] args) {
        RemoveDup a = new RemoveDup();

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        System.out.println(a.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int index = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
