package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PG64065 {

    public static void main(String[] args) {
        final PG64065 pg64065 = new PG64065();
        System.out.println(Arrays.toString(pg64065.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
    }

    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] tuple = s.split("},\\{");
        Arrays.sort(tuple, Comparator.comparingInt(String::length));
        List<Integer> result = new ArrayList<>();
        for (String str : tuple) {
            String[] nums = str.split(",");
            for (String num : nums) {
                if (!result.contains(Integer.parseInt(num))) {
                    result.add(Integer.parseInt(num));
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}
