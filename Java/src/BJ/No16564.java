package BJ;
// 히오스 프로게이머

import java.util.Arrays;
import java.util.Scanner;

public class No16564 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] levels = new int[N];
        for (int i=0; i<N; i++) {
            levels[i] = sc.nextInt();
        }

        Arrays.sort(levels);

        int left = levels[0];
        int right = levels[0] + K;
        int result = left;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canAchieve(levels, K, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    static boolean canAchieve(int[] levels, int K, int target) {
        int result = 0;

        for (int level : levels) {
            if (target > level) {
                result += target - level;
            }

            if (result > K) {
                return false;
            }
        }

        return true;
    }
}
