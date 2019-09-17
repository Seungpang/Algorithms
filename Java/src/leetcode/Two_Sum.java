class Solution {
    /*
    �ð����⵵ <-> �������⵵
    ��� 1. brute-force ��� ������ �õ�. 2�� ���� n*(n-1) /2 
        - �ð�: O(n^2)
        - ����: O(1)
    ��� 2. �ؽ��� ���, ���� 1�� ���鼭 �̹� �ô� ���� �ؽ��ʿ� ����
        - �ð�: O(n)
        - ����: O(n)
    */
    public int[] twoSum(int[] nums, int target) {
        //���1
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
        //���2        /*
        Map<Integer, Integer> map = new HashMap<>();//Ű-��, ���-�ε���
        
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