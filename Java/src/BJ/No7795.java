package BJ;
// 먹을 것인가 먹힐 것인가

import java.util.Arrays;
import java.util.Scanner;

public class No7795 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }

            Arrays.sort(b);

            int result = 0;
            for (int i = 0; i < n; i++) {
                result += binarySearch(b, a[i]);
            }

            System.out.println(result);
        }
    }

    private static int binarySearch(final int[] arr, final int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
