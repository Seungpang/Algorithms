package BJ;
// 로또

import java.util.Scanner;

public class No6603 {

    static int n;
    static int[] a;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            n = sc.nextInt();
            if (n == 0) {
                break;
            }
            a = new int[n];
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            go(0, 0);
            System.out.println();
        }
    }

    static void go(int start, int index) {
        if (index == 6) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    System.out.print(a[i] + " ");
                }
            }
            System.out.println();
        } else {
            for (int i = start; i < n; i++) {
                visited[i] = true;
                go(i + 1, index + 1);
                visited[i] = false;
            }
        }
    }
}
