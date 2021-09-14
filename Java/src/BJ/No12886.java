package BJ;
//dfs
//돌 그룹

import java.util.Scanner;

public class No12886 {

    public static int sum = 0;
    public static boolean[][] check = new boolean[1501][1501];
    public static void go(int x, int y) {
        if (check[x][y]) return;
        check[x][y] = true;
        int[] a = {x, y, sum - x - y};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a[i] < a[j]) {
                    int[] b = {x, y, sum - x - y};
                    b[i] += a[i];
                    b[j] -= a[i];
                    go(b[0], b[1]);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        sum = a + b + c;
        if (sum % 3 != 0) {
            System.out.println(0);
            System.exit(0);
        }
        go(a, b);
        if (check[sum / 3][sum / 3]) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
