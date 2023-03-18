package Programmers;

import java.util.Stack;

public class PG12973 {

    public static void main(String[] args) {
        final PG12973 pg12973 = new PG12973();
        System.out.println(pg12973.solution("baabaa"));
    }

    public int solution(String s)
    {
        if (s.length() == 0) {
            return 0;
        }
        
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index++);
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
