package codingInterview;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LC340 {

    public static void main(String[] args) {
        final LC340 lc340 = new LC340();
        System.out.println(lc340.lengthOfLongestSubstringKDistinct("eceba", 2));
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        while (right < s.length()) {
            map.put(s.charAt(right), right++);
            if (map.size() == k + 1) {
                int lowIndex = Collections.min(map.values());
                map.remove(s.charAt(right));
                left = lowIndex + 1;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
