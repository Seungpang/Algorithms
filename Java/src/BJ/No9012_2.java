package BJ;

import java.util.Scanner;
import java.util.Stack;

public class No9012_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n-- > 0) {
            System.out.println(isValid(sc.next()));
        }
    }

    private static String isValid(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return "NO";
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (stack.size() == 0) {
            return "YES";
        } else {
            return"NO";
        }
    }
}
