package BJ;
// Sort 마스터 배지훈의 후계자

import java.util.Arrays;
import java.util.Scanner;

public class No20551 {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);

        for (int i=0; i<M; i++) {
            int D = sc.nextInt();
            int result = lowerBound(A, D);
            if (result < N && A[result] == D) {
                System.out.println(result);
            } else {
                System.out.println(-1);
            }
        }
    }

    private static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
