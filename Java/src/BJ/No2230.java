package BJ;
// 수 고르기

import java.util.Arrays;
import java.util.Scanner;

public class No2230 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while (right < n) {
            int result = a[right] - a[left];
            if (result < m) {
                right++;
                continue;
            } else if (result == m) {
                ans = m;
                break;
            } else {
                ans = Math.min(ans, result);
                left++;
            }
        }
        System.out.println(ans);
    }
}
