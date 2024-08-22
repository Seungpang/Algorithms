package BJ;
// 뒤풀이

import java.util.Scanner;

public class No14575 {

    static int N, T;
    static int[] L, R;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        T = sc.nextInt();
        L = new int[N];
        R = new int[N];

        int maxL = 0, maxR = 0;
        for (int i = 0; i < N; i++) {
            L[i] = sc.nextInt();
            R[i] = sc.nextInt();
            maxL = Math.max(maxL, L[i]);
            maxR = Math.max(maxR, R[i]);
        }

        int result = binarySearch(maxL, maxR);
        System.out.println(result);
    }

    static int binarySearch(int low, int high) {
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int possibleResult = isPossible(mid);
            if (possibleResult == 0) {
                result = mid;
                high = mid - 1;
            } else if (possibleResult < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    static int isPossible(int S) {
        long minSum = 0, maxSum = 0;
        for (int i = 0; i < N; i++) {
            if (S < L[i]) return -1;
            minSum += Math.min(S, L[i]);
            maxSum += Math.min(S, R[i]);
        }
        if (minSum > T) return 1;
        if (maxSum < T) return -1;
        return 0;
    }
}
