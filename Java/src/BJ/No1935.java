package BJ;
// 후위 표기식2

import java.util.Scanner;
import java.util.Stack;

public class No1935 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        sc.nextLine();
        String s = sc.nextLine();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(a * b);

            } else if (s.charAt(i) == '+') {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(a + b);
            } else if (s.charAt(i) == '-') {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(a - b);
            } else if (s.charAt(i) == '/') {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push((double) arr[s.charAt(i) - 'A']);
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}
