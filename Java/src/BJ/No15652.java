package BJ;

import java.util.Scanner;

public class No15652 {

    static int n, m;
    static int[] a = new int[10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        go(1);
        System.out.print(sb);
    }

    public static void go(int index) {
        if (index == m + 1) {
            for (int i = 1; i <= m; i++) {
                sb.append(a[i]).append(" ");
            }
            sb.append("\n");
        } else {
            int start = a[index - 1];
            if (start == 0) {
                start = 1;
            }
            for (int i = start; i <= n; i++) {
                a[index] = i;
                go(index + 1);
                a[index] = 0;
            }
        }
    }
}
