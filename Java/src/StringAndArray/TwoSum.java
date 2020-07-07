package StringAndArray;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSum a = new TwoSum();
        int[] result = a.Solution(nums, target);
        for(int i : result)
            System.out.println(i);
    }

    public int[] Solution(int[] nums,int target ){
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                int mapValue = map.get(nums[i]);
                result[0] = mapValue;
                result[1] = i;
            } else{
                map.put(target-nums[i], i);
            }
        }
        return result;
    }
}
