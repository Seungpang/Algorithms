package codingInterview;

import java.util.HashMap;
import java.util.Map;

public class LC76 {

    public static void main(String[] args) {
        final LC76 lc76 = new LC76();
        System.out.println(lc76.minWindow("ADOBECODEBANC", "ABC"));
        //"BANC"
    }

    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> targetCounts = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = targetCounts.getOrDefault(t.charAt(i), 0);
            targetCounts.put(t.charAt(i), count + 1);
        }

        int targetSize = targetCounts.size();
        int left = 0;
        int right = 0;
        int windowSize = 0;
        Map<Character, Integer> windowCounts = new HashMap<>();
        int[] ans = {-1, 0, 0};
        while (right < s.length()) {
            char c = s.charAt(right);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (targetCounts.containsKey(c) && windowCounts.get(c).intValue() == targetCounts.get(c).intValue()) {
                windowSize++;
            }

            while (left <= right && windowSize == targetSize) {
                c = s.charAt(left);
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (targetCounts.containsKey(c) && windowCounts.get(c) < targetCounts.get(c)) {
                    windowSize--;
                }
                left++;
            }
            right++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
