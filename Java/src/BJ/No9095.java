package BJ;

import java.util.Scanner;

public class No9095 {

    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     for (int i = 0; i < n; i++) {
    //         int num = sc.nextInt();
    //         System.out.println(recur(num));
    //     }
    // }
    //
    // static int recur(int num) {
    //     if (num == 1) return 1;
    //     if (num == 2) return 2;
    //     if (num == 3)
    //         return 4;
    //     else {
    //         return recur(num - 3) + recur(num - 2) + recur(num - 1);
    //     }
    // }
    public static int go(int sum, int goal) {
        if (sum > goal) {
            return 0;
        }
        if (sum == goal) {
            return 1;
        }
        int now = 0;
        for (int i=1; i<=3; i++) {
            now += go(sum+i, goal);
        }
        return now;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(go(0, n));
        }
    }
}
