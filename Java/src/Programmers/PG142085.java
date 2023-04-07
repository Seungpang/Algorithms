package Programmers;
// 디펜스

import java.util.Comparator;
import java.util.PriorityQueue;

public class PG142085 {

    public static void main(String[] args) {
        final PG142085 pg142085 = new PG142085();
        System.out.println(pg142085.solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1}));
    }

    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int e : enemy) {
            n -= e;
            if (k == 0 && n < 0) {
                break;
            }

            pq.offer(e);
            if (n < 0 && k > 0) {
                n += pq.poll();
                k--;
            }
            answer++;
        }
        return answer;
    }
}
