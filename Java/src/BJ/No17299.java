package BJ;
//스택
//오등큰수

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class No17299 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] ans = new int[n];
        int[] freq = new int[1000001];
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(temp[i]);
            freq[a[i]] += 1;
        }

        Stack<Integer> s = new Stack<>();
        s.push(0);
        for (int i = 1; i < n; i++) {
            if (s.isEmpty()) {
                s.push(i);
            }
            while (!s.isEmpty() && freq[a[s.peek()]] < freq[a[i]]) {
                ans[s.pop()] = a[i];
            }
            s.push(i);
        }

        while (!s.empty()) {
            ans[s.pop()] = -1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(ans[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
