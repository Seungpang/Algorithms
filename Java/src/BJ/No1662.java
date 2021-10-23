package BJ;
//압축

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No1662 {

    static int[] paren = new int[50];
    static char[] s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> st = new Stack();
        s = br.readLine().toCharArray();

        for (int i = 0; i < s.length; i++) {
            if (s[i] == '(') {
                st.push(i);
            }
            if (s[i] == ')') {
                paren[st.pop()] = i;
            }
        }
        System.out.println(traversal(0, s.length));
    }

    static int traversal(int start, int end) {
        int sLength = 0;

        for (int i = start; i < end; i++) {
            if (s[i] == '(') {
                sLength += (s[i - 1] - '0') * traversal(i + 1, paren[i]) - 1;
                i = paren[i];
            } else {
                sLength++;
            }
        }
        return sLength;
    }
}
