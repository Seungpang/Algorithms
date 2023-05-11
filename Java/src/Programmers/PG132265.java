package Programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PG132265 {

    public static void main(String[] args) {
        final PG132265 a = new PG132265();
        System.out.println(a.solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
        System.out.println(a.solution(new int[]{1, 2, 3, 1, 4}));
    }

    public int solution(int[] topping) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map =new HashMap<>();
        for (int i=0; i<topping.length; i++) {
            map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
        }

        for (int i=0; i<topping.length; i++) {
            set.add(topping[i]);
            map.put(topping[i], map.get(topping[i]) -1);
            if (map.get(topping[i]) == 0) {
                map.remove(topping[i]);
            }
            if (set.size() == map.size()) {
                count++;
            }
        }

        return count;
    }
}
