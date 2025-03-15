package BJ;
// 최소 힙

import java.util.PriorityQueue;
import java.util.Scanner;

public class No1927 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int q = sc.nextInt();
            if (q == 0) {
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
            } else {
                pq.offer(q);
            }
        }

        System.out.println(sb);
    }
}
