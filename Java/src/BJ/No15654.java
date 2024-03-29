package BJ;

import java.util.Arrays;
import java.util.Scanner;

public class No15654 {

    static int n, m;
    static int[] a = new int[10];
    static int[] num;
    static boolean[] visited = new boolean[10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        num = new int[n];
        for (int i=0; i<n; i++) {
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);
        go(1);
        System.out.println(sb);
    }

    public static void go(int index) {
        if (index == m + 1) {
            for (int i = 1; i <= m; i++) {
                sb.append(num[a[i]]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 0; i < n; i++) {
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
}
