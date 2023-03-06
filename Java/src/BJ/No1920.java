package BJ;
//수 찾기
//이진탐색

import java.util.Arrays;
import java.util.Scanner;

public class No1920 {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int target = sc.nextInt();
            boolean find = false;
            int start = 0;
            int end = arr.length - 1;
            while (start <= end) {
                int midIndex = (start + end) / 2;
                int midValue = arr[midIndex];
                if (midValue > target) {
                    end = midIndex - 1;
                } else if (midValue < target) {
                    start = midIndex + 1;
                } else {
                    find = true;
                    break;
                }
            }

            if (find) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
