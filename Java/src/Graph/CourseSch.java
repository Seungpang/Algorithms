package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSch {
    public static void main(String[] args) {
        int course = 4;
//        int[][] nums = {{1,0},
//                {2,1},
//                {3,2}};

        int[][] nums2 = {{1,0},{0,1}};

        CourseSch a = new CourseSch();
        System.out.println(a.solution(course, nums2));
    }

    public boolean solution(int courseNumber, int[][] nums){
        if(courseNumber <= 0)
            return false;

        //inDegree 배열, Queue
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[courseNumber];

        int numsLength = nums.length;
        for(int i=0; i<numsLength; i++){
            inDegree[nums[i][1]]++;
        }

        int inDegreeLength =inDegree.length;
        for(int i=0; i<inDegreeLength; i++){
            if(inDegree[i]==0)
                queue.offer(i);
        }

        while (!queue.isEmpty()){
            int firstZeroVal = queue.poll();

            for(int i=0; i<numsLength; i++){
                if(firstZeroVal==nums[i][0]){
                    inDegree[nums[i][1]]--;
                    if(inDegree[nums[i][1]] == 0){
                        queue.offer(nums[i][1]);
                    }
                }
            }
        }

        for(int i=0; i<inDegreeLength; i++){
            if(inDegree[i]!=0)
                return false;
        }
        return true;
    }
}
