package BJ;
// n과 m(10)

import java.util.Arrays;
import java.util.Scanner;

public class No15664 {

    static int n, m;
    static int[] num, a = new int[10];
    static boolean[] visited = new boolean[10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);
        go(1);
        System.out.print(sb);
    }

    static void go(int index) {
        if (index == m + 1) {
            for (int i = 1; i <= m; i++) {
                sb.append(num[a[i]]).append(" ");
            }
            sb.append("\n");
        } else {
            int start = a[index - 1];
            int temp = 0;
            for (int i = start; i < n; i++) {
                if (!visited[i] && temp != num[i]) {
                    a[index] = i;
                    temp = num[i];
                    visited[i] = true;
                    go(index + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
