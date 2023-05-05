package BJ;
// 두 수의 합

import java.util.Arrays;
import java.util.Scanner;

public class No3273 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        Arrays.sort(a);
        int left = 0;
        int right = a.length - 1;
        int count = 0;
        while (left < right) {
            int sum = a[left] + a[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                count++;
                right--;
            }
        }
        System.out.println(count);
    }
}
