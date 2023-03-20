package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PG138476 {

    public static void main(String[] args) {
        final PG138476 pg138476 = new PG138476();
        System.out.println(pg138476.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
    }

    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> tangerineSizes = new HashMap<>();
        for (int size : tangerine) {
            tangerineSizes.put(size, tangerineSizes.getOrDefault(size, 0) + 1);
        }

        List<Integer> tangerineCount = new ArrayList<>(tangerineSizes.keySet());
        tangerineCount.sort((o1, o2) -> tangerineSizes.get(o2).compareTo(tangerineSizes.get(o1)));

        int answer = 0;
        for (int key : tangerineCount) {
            if (k <= 0) {
                break;
            }
            k -= tangerineSizes.get(key);
            answer++;
        }
        return answer;
    }
}
