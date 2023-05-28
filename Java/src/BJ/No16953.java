package BJ;
// A->B

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No16953 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextInt();
        long B = sc.nextInt();

        Queue<Long> q = new LinkedList<>();
        q.offer(A * 2);
        q.offer(A * 10 + 1);

        int answer = 0;
        while (!q.isEmpty()) {
            answer++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                long now = q.poll();
                if (now > B) {
                    continue;
                } else if (now == B) {
                    System.out.println(answer + 1);
                    return;
                }
                q.offer(now * 2);
                q.offer(now * 10 + 1);
            }
        }
        System.out.println(-1);

    }
}
