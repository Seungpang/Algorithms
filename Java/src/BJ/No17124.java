package BJ;
// 두 개의 배열

import java.util.Arrays;
import java.util.Scanner;

public class No17124 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            int[] c = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }

            Arrays.sort(b);
            Arrays.fill(c, Integer.MAX_VALUE);
            for (int i = 0; i < n; i++) {
                int left = 0;
                int right = m - 1;
                int result = Integer.MAX_VALUE;
                while (left <= right) {
                    int mid = (int) ((long) left + right) / 2;
                    if (mid <= m && a[i] >= b[mid]) {
                        if (result >= a[i] - b[mid]) {
                            c[i] = b[mid];
                            result = a[i] - b[mid];
                        }
                        left = mid + 1;
                    } else if (mid <= m && a[i] < b[mid]) {
                        if (result > b[mid] - a[i]) {
                            c[i] = b[mid];
                            result = b[mid] - a[i];
                        }
                        right = mid - 1;
                    }
                }
            }
            long result = 0;
            for (int i = 0; i < c.length; i++) {
                result += c[i];
            }
            System.out.println(result);
        }
    }
}
