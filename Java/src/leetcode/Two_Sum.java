class Solution {
    /*
    시간복잡도 <-> 공간복잡도
    대안 1. brute-force 모든 조합을 시도. 2중 루프 n*(n-1) /2 
        - 시간: O(n^2)
        - 공간: O(1)
    대안 2. 해쉬맵 사용, 루프 1개 돌면서 이미 봤던 값을 해쉬맵에 넣음
        - 시간: O(n)
        - 공간: O(n)
    */
    public int[] twoSum(int[] nums, int target) {
        //대안1
    	/*
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    int[] ret = new int[2];
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        return null;
         */
        //대안2        /*
        Map<Integer, Integer> map = new HashMap<>();//키-값, 밸류-인덱스
        
        for(int i = 0; i<nums.length; i++){
            int cur = nums[i];
            if(map.containsKey(target-cur)){
                int[] ret = new int[2];
                ret[0] = map.get(target-cur);
                ret[1] = i;
                return ret;
            }else{
                map.put(cur, i);
            }
        }
        return null;
    }
}