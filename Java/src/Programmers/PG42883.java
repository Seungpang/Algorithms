package Programmers;
// 큰 수 만들기

import java.util.Stack;
import java.util.stream.Collectors;

public class PG42883 {

    public static void main(String[] args) {
        final PG42883 pg42883 = new PG42883();
        System.out.println(pg42883.solution("4177252841", 4));
    }

    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            int num = number.charAt(i) - '0';
            while (!stack.isEmpty() && stack.peek() < num && k-- > 0) {
                stack.pop();
            }
            stack.push(num);
        }
        while (k-- > 0) {
            stack.pop();
        }
        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
