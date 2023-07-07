package Programmers;
// 모의고사

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PG42840 {

    public static void main(String[] args) {
        PG42840 pg42840 = new PG42840();
        System.out.println(Arrays.toString(pg42840.solution(new int[]{
                1,3,2,4,2
        }))); // [1,2,3]
    }

    public int[] solution(int[] answers) {
        int[] supoja1 = {1,2,3,4,5};
        int[] supoja2 = {2,1,2,3,2,4,2,5};
        int[] supoja3 = {3,3,1,1,2,2,4,4,5,5};
        int[] answer = new int[]{0, 0, 0};

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == supoja1[i % supoja1.length]) {
                answer[0]++;
            }
            if (answers[i] == supoja2[i % supoja2.length]) {
                answer[1]++;
            }
            if (answers[i] == supoja3[i % supoja3.length]) {
                answer[2]++;
            }
        }

        int maxNum = 0;
        for (int i : answer) {
            maxNum = Math.max(i, maxNum);
        }

        List<Integer> count = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (answer[i] == maxNum) {
                count.add(i + 1);
            }
        }

        return count.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
