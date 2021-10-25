package BJ;
//스택
//단어뒤집기 2

import java.util.Scanner;
import java.util.Stack;

public class No17413 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> s = new Stack<>();
        boolean flag = false;
        for (char c : str.toCharArray()) {
            if (c == '<') {
                print(s);
                flag = true;
                System.out.print(c);
            } else if (c == '>') {
                flag = false;
                System.out.print(c);
            } else if (flag) {
                System.out.print(c);
            } else {
                if (c == ' ') {
                    print(s);
                    System.out.print(c);
                } else {
                    s.push(c);
                }
            }
        }
        print(s);
    }

    public static void print(Stack<Character> s) {
        while (!s.isEmpty()) {
            System.out.print(s.peek());
            s.pop();
        }
    }
}
