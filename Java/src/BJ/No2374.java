package BJ;
// 같은 수로 만들기

import java.util.Scanner;
import java.util.Stack;

public class No2374 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        long result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            max = Math.max(max, x);

            if (stack.isEmpty()) {
                stack.push(x);
            } else {
                if (stack.peek() < x) {
                    result += x - stack.pop();
                    stack.push(x);
                } else if (stack.peek() > x) {
                    stack.pop();
                    stack.push(x);
                }
            }
        }

        while (!stack.isEmpty()) {
            int num = stack.pop();
            result += max - num;
        }

        System.out.println(result);
    }
}
