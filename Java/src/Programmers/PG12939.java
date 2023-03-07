package Programmers;

import java.util.Arrays;

public class PG12939 {

    public static void main(String[] args) {
        final PG12939 pg12939 = new PG12939();
        System.out.println(pg12939.solution("-1 -2 4 -4"));
    }

    public String solution(String s) {
        String[] numbers = s.split(" ");
        int min, max, n;
        min = max = Integer.parseInt(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            n = Integer.parseInt(numbers[i]);
            if (min > n) {
                min = n;
            }
            if (max < n) {
                max = n;
            }
        }
        return min + " " + max;
    }
}
