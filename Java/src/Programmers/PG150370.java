package Programmers;
// 개인정보 수집 유효기간

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PG150370 {

    public static void main(String[] args) {
        PG150370 a = new PG150370();
        System.out.println(Arrays.toString(a.solution("2020.01.01", new String[]{"Z 3", "D 5"},
                new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"})));
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<terms.length; i++) {
            String[] s = terms[i].split(" ");
            map.put(s[0], Integer.parseInt(s[1]));
        }
        int target = convertDay(today);
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            if (target >= convertDay(privacy[0]) + map.get(privacy[1]) * 28) {
                result.add(i+1);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public int convertDay(String date) {
        String[] times = date.split("\\.");
        return Integer.parseInt(times[0]) * 12 * 28 + Integer.parseInt(times[1]) * 28 + Integer.parseInt(times[2]);
    }
}
