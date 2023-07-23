package BJ;
// 괄호의 값

import java.util.Scanner;
import java.util.Stack;

public class No2504 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> stack = new Stack();
        int result = 0;
        int temp = 1;

        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur == '(') {
                stack.push(cur);
                temp *= 2;
            } else if (cur == '[') {
                stack.push(cur);
                temp *= 3;
            } else if (cur == ')' || cur == ']'){
                if (stack.isEmpty() || (cur == ')' && stack.peek() != '(') || (cur == ']' && stack.peek() != '[')) {
                    System.out.println(0);
                    return;
                }
                if ((cur == ')' && str.charAt(i - 1) == '(') || (cur == ']' && str.charAt(i - 1) == '[')) {
                    result += temp;
                }
                stack.pop();
                temp /= (cur == ')' ? 2 : 3);
            } else {
                System.out.println(0);
                return;
            }
        }

        System.out.println(stack.isEmpty() ? result : 0);
    }
}
