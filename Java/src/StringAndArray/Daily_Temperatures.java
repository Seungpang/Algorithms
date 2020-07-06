package Sort;

import java.util.Stack;

public class Daily_Temperatures {
    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = solution(nums);

        System.out.println("=======result========");
        for(int i : res){
            System.out.print(i+" ");
        }
    }

    public static int[] solution(int[] temper){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temper.length];

        for(int i=0; i<temper.length; i++){
            while(!stack.isEmpty() && temper[stack.peek()] < temper[i]){
                int index = stack.pop();
                result[index] = i-index;
            }
            stack.push(i);
        }
        return result;
    }
}
