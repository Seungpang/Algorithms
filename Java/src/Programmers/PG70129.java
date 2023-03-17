package Programmers;

import java.util.Arrays;

public class PG70129 {

    public static void main(String[] args) {
        final PG70129 pg70129 = new PG70129();
        System.out.println(Arrays.toString(pg70129.solution("110010101001")));
    }

    public int[] solution(String s) {
        int[] answer = {0, 0};
        int len = s.length();

        while (len != 1) {
            s = s.replaceAll("0", "");
            int zeroCount = len - s.length();
            answer[1] += zeroCount;
            s = Integer.toBinaryString(s.length());
            answer[0]++;
            len = s.length();
        }
        return answer;
    }
}
