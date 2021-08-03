package LeetCode;

import java.lang.annotation.Retention;

public class Remove_Element {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;

        Remove_Element a = new Remove_Element();
        System.out.println(a.removeElement(nums, 3));
    }

    public int removeElement(int[] nums, int vol) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != vol)
                nums[index++] = nums[i];
        }
        return index;
    }

}
