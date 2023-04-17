package Programmers;
// 명예의 전당(1)

import java.util.Arrays;
import java.util.PriorityQueue;

public class PG138477 {

    public static void main(String[] args) {
        final PG138477 pg138477 = new PG138477();
        System.out.println(Arrays.toString(pg138477.solution(3, new int[]{10, 100, 20, 150, 1, 100, 200})));
    }

    public int[] solution(int k, int[] score) {
        int n = score.length;
        int[] answer = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i<n; i++) {
            pq.offer(score[i]);
            if (pq.size() > k) {
                pq.remove();
            }
            answer[i] = pq.peek();
        }
        return answer;
    }
}
