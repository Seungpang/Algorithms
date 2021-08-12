package BJ;

import java.util.Scanner;

public class No15650 {

    static boolean[] c = new boolean[10];
    static int[] a = new int[10];
    static StringBuilder sb = new StringBuilder();

    static void go(int index, int selected, int n, int m) {
        if (selected == m) {
            for (int i = 0; i < m; i++) {
                sb.append(a[i]);
                if (i != m - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
            return;
        }
        if (index > n) {
            return;
        }
        a[selected] = index;
        go(index + 1, selected + 1, n, m);
        a[selected] = 0;
        go(index + 1, selected, n, m);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        go(1, 0, n, m);
        System.out.print(sb.toString());
    }
}
