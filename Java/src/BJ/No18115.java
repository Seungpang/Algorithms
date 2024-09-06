package BJ;
// 카드 놓기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class No18115 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] commands = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = N - 1; i >= 0; i--) {
            commands[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deck = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (commands[i - 1] == 1) {
                deck.addFirst(i);
            } else if (commands[i - 1] == 2) {
                int temp = deck.removeFirst();
                deck.addFirst(i);
                deck.addFirst(temp);
            } else {
                deck.addLast(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : deck) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}
