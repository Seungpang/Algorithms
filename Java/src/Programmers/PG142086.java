package Programmers;

import java.util.Arrays;

public class PG142086 {

    public static void main(String[] args) {
        final PG142086 pg142086 = new PG142086();
        final String banana = "banana";
        System.out.println(banana.lastIndexOf(banana.charAt(5), 4));
        //System.out.println(Arrays.toString(pg142086.solution("banana")));
    }

    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        answer[0] = -1;

        for (int i = 1; i < s.length(); i++) {
            int x = s.lastIndexOf(s.charAt(i), i - 1);
            if (x != -1) {
                answer[i] = i - x;
            } else {
                answer[i] = x;
            }
        }
        return answer;
    }
}
