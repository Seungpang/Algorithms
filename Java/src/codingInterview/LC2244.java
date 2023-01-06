package codingInterview;

import java.util.HashMap;
import java.util.Map;

public class LC2244 {

    public static void main(String[] args) {
        final LC2244 lc2244 = new LC2244();
        System.out.println(lc2244.minimumRounds(new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4}));
    }

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int task : tasks) {
            frequency.put(task, frequency.getOrDefault(task, 0) + 1);
        }

        int minimumRounds = 0;
        for (Integer count : frequency.values()) {
            if (count == 1) {
                return -1;
            }

            if (count % 3 == 0) {
                minimumRounds += count / 3;
            } else {
                //count % 3 = 1, count % 3 = 2
                minimumRounds += count / 3 + 1;
            }
        }
        return minimumRounds;
    }
}
