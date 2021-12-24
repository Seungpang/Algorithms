package BJ;
//단어 뒤집기

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;


public class No9093 {

    // public static void main(String[] args) throws IOException {
    //     BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    //     int t = Integer.parseInt(bf.readLine());
    //     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    //     while (t-- > 0) {
    //         String str = bf.readLine() + "\n";
    //         Stack<Character> s = new Stack<>();
    //         for (char ch : str.toCharArray()) {
    //             if (ch == '\n' || ch == ' ') {
    //                 while (!s.isEmpty()) {
    //                     bw.write(s.pop());
    //                 }
    //                 bw.write(ch);
    //             } else {
    //                 s.push(ch);
    //             }
    //         }
    //     }
    //     bw.flush();
    // }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(bf.readLine());
        for (int i = 0; i < testCase; i++) {
            Stack<Character> stack = new Stack<>();
            String s = bf.readLine();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == ' ') {
                    while (!stack.empty()) {
                        bw.write(stack.pop());
                    }
                    bw.write(" ");
                } else {
                    stack.add(s.charAt(j));
                }
            }
            while(!stack.empty()) {
                bw.write(stack.pop());
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
