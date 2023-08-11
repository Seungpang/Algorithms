package Programmers;
// 신입사원 교육

import java.util.PriorityQueue;

public class PCCP2_02 {

    public static void main(String[] args) {
        PCCP2_02 pccp202 = new PCCP2_02();
        System.out.println(pccp202.solution(new int[]{10, 3, 7, 2}, 2));
    }

    public int solution(int[] ability, int number) {
        int n = ability.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i=0; i<n; i++) {
            pq.add(ability[i]);
        }

        int sum = 0;

        for (int i=0; i<number; i++) {
            int employee1 = pq.poll();
            int employee2 = pq.poll();

            int combinedAbility = employee1 + employee2;
            pq.add(combinedAbility);
            pq.add(combinedAbility);
        }

        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;
    }
}
