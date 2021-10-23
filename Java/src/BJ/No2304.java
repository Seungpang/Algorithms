package BJ;
//창고 다각형

import java.util.Scanner;

public class No2304 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[1001];
        int n = sc.nextInt();

        int max_index = 0;
        int min_index = 0;
        int max_hight_index = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            a[x] = y;
            max_index = Math.max(max_index, x);
            min_index = Math.min(min_index, x);

            if (a[x] > a[max_hight_index]) {
                max_hight_index = x;
            }
        }

        int sum = 0;
        int h = 0;
        for (int i = min_index; i < max_hight_index; i++) {
            h = Math.max(h, a[i]);
            sum += h;
        }

        h = 0;
        for (int i = max_index; i > max_hight_index; i--) {
            h = Math.max(h, a[i]);
            sum += h;
        }
        System.out.println(a[max_hight_index] + sum);
    }
}