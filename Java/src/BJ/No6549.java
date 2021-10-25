package BJ;
//스택
//히스토그램에서 가장 큰 직사각형

import java.util.Scanner;
import java.util.Stack;

public class No6549 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            Stack<Integer> s = new Stack<>();
            long ans = 0;
            for (int i = 0; i < n; i++) {
                int left = i;
            }
        }
    }
}
