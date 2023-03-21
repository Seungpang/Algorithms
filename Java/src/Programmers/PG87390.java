package Programmers;

import java.util.Arrays;

public class PG87390 {

    public static void main(String[] args) {
        final PG87390 pg87390 = new PG87390();
        System.out.println(Arrays.toString(pg87390.solution(4, 7, 14)));
    }

    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        for (int i=0; i<answer.length; i++) {
            int y = (int) (left / n) + 1;
            int x = (int) (left % n) + 1;
            left++;
            answer[i] = Math.max(x,y);
        }
        return answer;
    }
}
