package Programmers;

import java.util.Arrays;
import java.util.Collections;

public class Lv1_정수_내림차순으로_배치하기 {

    public static void main(String[] args) {
        Lv1_정수_내림차순으로_배치하기 sol = new Lv1_정수_내림차순으로_배치하기();
        System.out.println(sol.solution(118372));
    }

    public long solution(long n) {
        String[] arr = (String.valueOf(n)).split("");
        Arrays.sort(arr, Collections.reverseOrder());

        return Long.parseLong(String.join("", arr));
    }
}
