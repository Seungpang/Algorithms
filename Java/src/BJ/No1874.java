package BJ;
//스택
//스택 수열

import java.util.Scanner;
import java.util.Stack;

public class No1874 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        solve(a);
    }

    public static void solve(int[] a) {
        int n = a.length;
        Stack<Integer> s = new Stack<>();
        int m = 0;
        StringBuilder sb = new StringBuilder();
        for (int i : a) {
            if (i > m) {
                while (i > m) {
                    s.push(++m);
                    sb.append("+\n");
                }
                s.pop();
                sb.append("-\n");
            } else {
                if (s.peek() != i) {
                    System.out.println("NO");
                    return;
                }
                s.pop();
                sb.append("-\n");
            }
        }
        System.out.println(sb);
    }
}
