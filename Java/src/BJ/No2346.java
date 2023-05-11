package BJ;
// 풍선 터트리기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class No2346 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            deque.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (deque.size() > 1) {
            int now = deque.poll();
            sb.append(now + 1).append(" ");
            if (a[now] > 0) {
                a[now]--;
            }
            while (a[now] != 0) {
                if (a[now] > 0) {
                    deque.addLast(deque.pollFirst());
                    a[now]--;
                } else {
                    deque.addFirst(deque.pollLast());
                    a[now]++;
                }
            }
        }
        sb.append(deque.poll() + 1);
        System.out.println(sb);
    }
}
