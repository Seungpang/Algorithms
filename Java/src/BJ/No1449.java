package BJ;
// 수리공 항승

import java.util.Scanner;

public class No1449 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[] a = new int[1001];

        for (int i = 0; i < n; i++) {
            int index = sc.nextInt();
            a[index] = 1;
        }

        int count = 0;
        for (int i = 1; i <= 1000; i++) {
            if (a[i] != 0) {
                i += l - 1;
                count++;
            }
        }
        System.out.println(count);
    }
}
