package Programmers;

import java.util.HashSet;
import java.util.Set;

public class PG131701 {

    public static void main(String[] args) {
        final PG131701 pg131701 = new PG131701();
        System.out.println(pg131701.solution(new int[]{7, 9, 1, 1, 4}));
    }

    public int solution(int[] elements) {
        Set<Integer> answer = new HashSet<>();
        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;
                for (int k = 0; k < i; k++) {
                    if (j + k > elements.length - 1) {
                        sum += elements[j + k - elements.length];
                    } else {
                        sum += elements[j + k];
                    }
                }
                answer.add(sum);
            }
        }
        return answer.size();
    }
}
