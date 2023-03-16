package Programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class PG12941 {

    public static void main(String[] args) {
        final Programmers.PG12941 pg12941 = new PG12941();
        System.out.println(pg12941.solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
    }

    public int solution(int[] A, int[] B) {
        PriorityQueue<Integer> a = new PriorityQueue<>();
        PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            a.add(A[i]);
            b.add(B[i]);
        }

        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result += a.poll() * b.poll();
        }
        return result;
    }
}
