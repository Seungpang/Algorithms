package BJ;
// n과 m(12)

import java.util.Arrays;
import java.util.Scanner;

public class No15666 {
    static int n, m;
    static int[] a = new int[10], num = new int[10];
    static boolean[] check = new boolean[10002];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int idx = 0;
        while (n-- > 0) {
            num[idx] = sc.nextInt();
            if (check[num[idx]]) {
                continue;
            }
            check[num[idx]] = true;
            idx++;
        }
        n = idx;
        Arrays.sort(num, 0, n);
        go(1);
        System.out.println(sb);
    }

    static void go(int index) {
        if (index == m + 1) {
            for (int i = 1; i <= m; i++) {
                sb.append(num[a[i]]).append(" ");
            }
            sb.append("\n");
        } else {
            int start = a[index - 1];
            for (int i = start; i < n; i++) {
                a[index] = i;
                go(index + 1);
            }
        }
    }
}
