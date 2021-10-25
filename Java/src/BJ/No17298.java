package BJ;
//스택
//오큰수

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class No17298 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        s.push(0);
        for (int i = 0; i < n; i++) {
            if (s.empty()) {
                s.push(i);
            }
            while (!s.empty() && a[s.peek()] < a[i]) {
                ans[s.peek()] = a[i];
                s.pop();
            }
            s.push(i);
        }

        while (!s.empty()) {
            ans[s.peek()] = -1;
            s.pop();
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(ans[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
