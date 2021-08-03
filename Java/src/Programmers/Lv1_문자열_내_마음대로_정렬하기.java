package Programmers;

import java.util.ArrayList;
import java.util.Collections;

public class Lv1_문자열_내_마음대로_정렬하기 {

    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        Lv1_문자열_내_마음대로_정렬하기 sol = new Lv1_문자열_내_마음대로_정렬하기();
        System.out.println(sol.solution(strings, 1).toString());
    }

    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];

        ArrayList<String> arr = new ArrayList<String>();

        for (int i=0; i<strings.length; i++) {
            arr.add(strings[i].charAt(n) + strings[i]);
        }

        Collections.sort(arr);

        for (int i=0; i<arr.size(); i++) {
            answer[i] = arr.get(i).substring(1);
        }

        return answer;
    }

}
