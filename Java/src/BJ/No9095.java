package BJ;

import java.util.Scanner;

public class No9095 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            System.out.println(recur(num));
        }
    }

    static int recur(int num) {
        if (num == 1) return 1;
        if (num == 2) return 2;
        if (num == 3)
            return 4;
        else {
            return recur(num - 3) + recur(num - 2) + recur(num - 1);
        }
    }
}
