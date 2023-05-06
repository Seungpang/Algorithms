package BJ;
// 프린터 큐

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No1966 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                q.offer(a[i]);
            }

            Arrays.sort(a);
            int size = a.length - 1;
            int answer = 0;
            while (!q.isEmpty()) {
                int now = q.poll();
                if (now == a[size- answer]) {
                    answer++;
                    m--;
                    if (m < 0) {
                        break;
                    }
                } else {
                    q.offer(now);
                    m--;
                    if (m < 0) {
                        m = q.size() - 1;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
