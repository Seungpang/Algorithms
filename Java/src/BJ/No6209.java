package BJ;
// 제자리 멀리뛰기

import java.util.Arrays;
import java.util.Scanner;

public class No6209 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] stones = new int[n + 2];
        stones[0] = 0;
        stones[n + 1] = d;
        for (int i = 0; i < n; i++) {
            stones[i] = sc.nextInt();
        }

        Arrays.sort(stones);

        int left = 0;
        int right = d;
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canJump(mid, stones, n - m + 2)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    static boolean canJump(int dist, int[] stones, int required) {
        int count = 1;
        int prev = stones[0];

        for (int i = 1; i < stones.length; i++) {
            if (stones[i] - prev >= dist) {
                count++;
                prev = stones[i];
                if (count >= required) {
                    return true;
                }
            }
        }

        return false;
    }
}
