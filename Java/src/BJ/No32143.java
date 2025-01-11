package BJ;
// 카드 게임 (Hard)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class No32143 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int h = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Queue<Integer> cards = new PriorityQueue<>();
        int tempNum;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            tempNum = Integer.parseInt(st.nextToken());
            cards.offer(tempNum);
            sum += tempNum;
        }

        StringBuilder sb = new StringBuilder();
        if (sum < h) {
            sb.append(-1).append("\n");
        } else {
            while (sum - cards.peek() >= h) {
                sum -= cards.poll();
            }
            sb.append(cards.size()).append("\n");
        }

        for (int i = 0; i < q; i++) {
            tempNum = Integer.parseInt(br.readLine());
            sum += tempNum;
            cards.offer(tempNum);
            if (sum < h) {
                sb.append(-1).append("\n");
            } else {
                while (sum - cards.peek() >= h) {
                    sum -= cards.poll();
                }
                sb.append(cards.size()).append("\n");
            }
        }

        System.out.print(sb);
    }
}
