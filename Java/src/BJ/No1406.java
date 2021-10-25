package BJ;
//스택
//에디터

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            left.push(s.charAt(i));
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] line = br.readLine().split(" ");
            char cmd = line[0].charAt(0);
            if (cmd == 'L') {
                if (!left.isEmpty()) {
                    right.push(left.pop());
                }
            } else if (cmd == 'D') {
                if (!right.isEmpty()) {
                    left.push(right.pop());
                }
            } else if (cmd == 'B') {
                if (!left.isEmpty()) {
                    left.pop();
                }
            } else if (cmd == 'P') {
                char c = line[1].charAt(0);
                left.push(c);
            }
        }
        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}
