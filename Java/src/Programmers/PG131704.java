package Programmers;

import java.util.Stack;

public class PG131704 {

    public static void main(String[] args) {
        final PG131704 a = new PG131704();
        System.out.println(a.solution(new int[]{4,3,1,2,5})); // 2
    }

    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();

        int answer = 0;
        int idx = 0;
        for (int i=1; i<=order.length; i++) {
            boolean flag = false;
            if (i == order[idx]) {
                idx++;
                answer++;
                flag = true;
            }

            while (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                answer++;
                idx++;
                flag = true;
            }

            if (!flag) {
                stack.push(i);
            }
        }
        while (!stack.isEmpty() && stack.peek() == order[idx]) {
            stack.pop();
            idx++;
            answer++;
        }

        return answer;
    }
}
