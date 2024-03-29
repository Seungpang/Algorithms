package BJ;
//자료 구조
//오아시스 재결합

import java.util.Scanner;
import java.util.Stack;

public class No3015 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Stack<Integer> s = new Stack<>();
        Stack<Integer> c = new Stack<>();
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int h = a[i];
            int cnt = 1;
            while (!s.empty()) {
                if (s.peek() <= a[i]) {
                    ans += (long) c.peek();
                    if (s.peek() == a[i]) {
                        cnt += c.peek();
                    }
                    s.pop();
                    c.pop();
                } else {
                    break;
                }
            }
            if (!s.empty()) {
                ans += 1;
            }
            s.push(h);
            c.push(cnt);
        }
        System.out.println(ans);
    }
}
