package BJ;
// 절댓값 힙

import java.util.PriorityQueue;
import java.util.Scanner;

public class No11286 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> {
                    int absA = Math.abs(a);
                    int absB = Math.abs(b);
                    if (absA == absB) {
                        return a - b;
                    }
                    return absA - absB;
                }
        );

        for (int i = 0; i < N; i++) {
            int q = sc.nextInt();
            if (q == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.offer(q);
            }

        }
    }
}
