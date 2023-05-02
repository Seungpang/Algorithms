package BJ;
// N과 M(8)

import java.util.Arrays;
import java.util.Scanner;

public class No15667 {

    static int[] a;
    static int[] c;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        a = new int[n];
        c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        go(0, 0, n, m);
        System.out.println(sb);
    }

    private static void go(int index, int selected, int n, int m) {
        if (selected == m) {
            for (int i = 0; i < m; i++) {
                sb.append(a[c[i]]);
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
        for (int i = index; i < n; i++) {
            c[selected] = i;
            go(i, selected + 1, n, m);
        }
    }
}
