package BJ;
//브루트 포스-재귀
//부분수열의 합

import java.util.Scanner;

public class No14225 {

    static boolean[] c = new boolean[20 * 100000 + 10];
    static int[] a = new int[20];
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        go(0, 0);
        for (int i = 1; ; i++) {
            if (c[i] == false) {
                System.out.println(i);
                break;
            }
        }
    }

    static void go(int i, int sum) {
        if (i == n) {
            c[sum] = true;
            return;
        }
        go(i + 1, sum + a[i]);
        go(i + 1, sum);
    }
}
