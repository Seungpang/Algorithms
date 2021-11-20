package Programmers;
//힙
//더 맵게

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PG42626 {

    public static void main(String[] args) {
        PG42626 a = new PG42626();
        int[] scoville = {14, 21, 32, 94, 10, 12};
        System.out.println(a.solution(scoville, 40));
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int one : scoville) {
            pq.offer(one);
        }

        while (pq.peek() <= K) {
            if (pq.size() == 1) {
                return -1;
            }
            int a = pq.poll();
            int b = pq.poll();

            int reuslt = a + (b * 2);
            pq.offer(reuslt);
            answer++;
        }
        return answer;
    }
}
