package BJ;
// 최대 힙

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class No11279 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            int command = sc.nextInt();
            if (command == 0) {
                System.out.println(pq.isEmpty() ? 0 : pq.poll());
            } else {
                pq.offer(command);
            }
        }
    }
}
