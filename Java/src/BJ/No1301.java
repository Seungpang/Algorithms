package BJ;
// 비즈 공예

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class No1301 {
    static int N;
    static int[] counts = new int[5];
    static Map<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            counts[i] = sc.nextInt();
        }

        long result = dp(counts, 0, 0);
        System.out.println(result);
    }

    static long dp(int[] counts, int last1, int last2) {
        boolean allZero = true;
        for (int i = 0; i < N; i++) {
            if (counts[i] != 0) {
                allZero = false;
                break;
            }
        }
        if (allZero) {
            return 1;
        }

        long key = getKey(counts, last1, last2);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        long totalWays = 0;

        for (int i = 0; i < N; i++) {
            if (counts[i] > 0 && (i + 1) != last1 && (i + 1) != last2) {
                counts[i]--;
                totalWays += dp(counts, i + 1, last1);
                counts[i]++;
            }
        }

        memo.put(key, totalWays);
        return totalWays;
    }

    static long getKey(int[] counts, int last1, int last2) {
        long key = 0;
        key |= counts[0];
        key |= ((long) counts[1]) << 4;
        key |= ((long) counts[2]) << 8;
        key |= ((long) counts[3]) << 12;
        key |= ((long) counts[4]) << 16;
        key |= ((long) last1) << 20;
        key |= ((long) last2) << 23;
        return key;
    }
}
