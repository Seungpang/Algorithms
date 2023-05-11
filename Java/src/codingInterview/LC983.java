package codingInterview;

import java.util.HashSet;
import java.util.Set;

public class LC983 {

    public static void main(String[] args) {
        final LC983 lc983 = new LC983();
        System.out.println(lc983.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
    }

    public int mincostTickets(int[] days, int[] costs) {
        int maxDay = days[days.length - 1];
        int[] dp = new int[maxDay + 1];
        Set<Integer> travelDays = new HashSet<>();
        for (int day : days) {
            travelDays.add(day);
        }
        dp[0] = 0;
        for (int i = 1; i <= maxDay; i++) {
            if (!travelDays.contains(i)) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.min(dp[i - 1] + costs[0], Math.min(dp[Math.max(0, i - 7)] + costs[1], dp[Math.max(0, i - 30)] + costs[2]));
            }
        }
        return dp[maxDay];
    }
}
