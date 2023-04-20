package Programmers;
// 야근 지수

import java.util.Comparator;
import java.util.PriorityQueue;

public class PG12927 {

    public static void main(String[] args) {
        final PG12927 pg12927 = new PG12927();
        System.out.println(pg12927.solution(4, new int[]{4,3,3}));
        System.out.println(pg12927.solution(1, new int[]{2,1,2}));
        System.out.println(pg12927.solution(3, new int[]{1,1}));
    }

    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int work : works) {
            pq.offer(work);
        }

        int work = 0;
        while (n != 0) {
            if (pq.isEmpty()) {
                return 0;
            }
            work = pq.poll();
            work--;
            n--;

            if (work != 0) {
                pq.offer(work);
            }
        }

        while (!pq.isEmpty()) {
            int num = pq.poll();
            answer += Math.pow(num, 2);
        }

        return answer;
    }
}
