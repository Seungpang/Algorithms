package codingInterview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC1207 {

    public static void main(String[] args) {
        final LC1207 lc1207 = new LC1207();
        System.out.println(lc1207.uniqueOccurrences(new int[]{1,2,2,1,1,3}));
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Integer> set = new HashSet<>(map.values());
        return map.size() == set.size();
    }
}
