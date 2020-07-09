package StringAndArray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {

    public static void main(String[] args) {
        KthLargest a = new KthLargest();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k=2;
        System.out.println(a.solution_array(nums, k));
        System.out.println(a.solution_pq(nums, k));
    }

    public int solution_array(int[] nums, int k){

        int length = nums.length;
        Arrays.sort(nums);
        return nums[length-k];
    }

    public int solution_pq(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comp);
        for(int val: nums){
            pq.offer(val);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }

    Comparator<Integer> Comp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    };

    public void print(int[] nums){
        for(int i:nums)
            System.out.println("i "+i);
    }
}
