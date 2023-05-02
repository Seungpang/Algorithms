package BJ;

import java.util.Scanner;

public class No15649 {

    static int n, m;
    static int[] a = new int[10];
    static boolean[] visited = new boolean[10];

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        go(0);
        System.out.println(sb);
    }

    public static void go(int index) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(a[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            a[index] = i;
            go(index + 1);
            visited[i] = false;
        }
    }
}
