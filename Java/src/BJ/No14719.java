package BJ;
//빗물

import java.util.Scanner;

public class No14719 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int[] a = new int[w];
        for (int i = 0; i < w; i++) {
            a[i] = sc.nextInt();
        }

        int left, right, result;
        result = 0;
        for (int i = 1; i < w - 1; i++) {
            left = right = 0;
            for (int j = 0; j < i; j++) {
                left = Math.max(a[j], left);
            }

            for (int j = i + 1; j < w; j++) {
                right = Math.max(a[j], right);
            }

            if (a[i] < left && a[i] < right) {
                result += Math.min(left, right) - a[i];
            }
        }
        System.out.println(result);
    }
}
