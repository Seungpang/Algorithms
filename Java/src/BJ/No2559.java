package BJ;
// 수열

import java.util.Scanner;

public class No2559 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        int i=1;
        int sum = 0;
        while (i<=k) sum += a[i++];

        int max = sum;
        while (i <= n) {
            sum += a[i] - a[i - k];
            if (max < sum) {
                max = sum;
            }
            i++;
        }
        System.out.println(max);
    }
}
