package Programmers;

import java.util.Arrays;
import java.util.Collections;

public class Lv1_문자열_내림차순으로_배치하기 {

    public static void main(String[] args) {
        Lv1_문자열_내림차순으로_배치하기 sol = new Lv1_문자열_내림차순으로_배치하기();
        System.out.println(sol.solution("Zbcdefg"));
    }

    public String solution(String s) {

        Character[] arr = new Character[s.length()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.charAt(i);
        }

        Arrays.sort(arr, Collections.reverseOrder());
        s = "";

        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
        }

        return s;
    }
}
