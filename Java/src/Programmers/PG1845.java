package Programmers;
//찾아라 프로그래밍 마에스터
//폰켓몬

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PG1845 {

    public static void main(String[] args) {
        PG1845 a = new PG1845();
        int[] nums = {3, 3, 3, 2, 2, 4};
        System.out.println(a.solution2(nums));
    }

    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length /2;

        for (int i : nums) {
            if (set.contains(i)) continue;
            set.add(i);
        }
        return Math.min(set.size(), len);
    }

    public int solution2(int[] nums) {
        return Arrays.stream(nums)
            .boxed()
            .collect(Collectors.collectingAndThen(Collectors.toSet(),
                set -> Integer.min(set.size(), nums.length / 2)));
    }
}
