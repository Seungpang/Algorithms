package BJ;
// 회전하는 큐

import java.util.LinkedList;
import java.util.Scanner;

public class No1021 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] target = new int[m];
        for (int i = 0; i < m; i++) {
            target[i] = sc.nextInt();
        }

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            while (true) {
                int now = target[i];
                if (now == deque.peek()) {
                    deque.poll();
                    break;
                }
                int idx = deque.indexOf(now);
                if (idx > deque.size() / 2) {
                    deque.offerFirst(deque.pollLast());
                    result++;
                } else {
                    deque.offerLast(deque.pollFirst());
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
