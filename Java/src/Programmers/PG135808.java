package Programmers;
// 과일 장수
import java.util.Arrays;

public class PG135808 {

    public static void main(String[] args) {
        final PG135808 pg135808 = new PG135808();
        System.out.println(pg135808.solution(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));
    }

    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        for (int i = score.length - 1; i >= m; i-=m) {
            answer = score[i-m] * m;
        }
        return answer;
    }
}
