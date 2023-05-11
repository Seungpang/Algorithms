package Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PG131127 {

    public static void main(String[] args) {
        final PG131127 pg131127 = new PG131127();
        System.out.println(
                pg131127.solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1},
                        new String[]{
                                "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork",
                                "rice", "pot", "banana", "apple", "banana"
                        }));
    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for (int i = 0; i < discount.length - 9; i++) {
            int j;
            for (j=0; j<want.length; j++) {
                int count = 0;
                for (int k = i; k < i + 10; k++) {
                    if (discount[k].equals(want[j])) {
                        count++;
                    }
                }
                if (count != number[j]) {
                    break;
                }
            }
            if (j == want.length) {
                answer++;
            }
        }
        return answer;
    }
}
