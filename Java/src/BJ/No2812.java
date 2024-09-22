package BJ;
// 크게 만들기

import java.util.Scanner;
import java.util.Stack;

public class No2812 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Stack<Character> stack = new Stack<>();
        String num = sc.next();

        for (int i = 0; i < N; i++) {
            char c = num.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && K > 0) {
                stack.pop();
                K--;
            }
            stack.push(c);
        }

        while (K > 0) {
            stack.pop();
            K--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.reverse());
    }
}
