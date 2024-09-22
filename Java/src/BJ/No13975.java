package BJ;
// 파일 합치기 3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No13975 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < K; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long result = 0;
            while (pq.size() >= 2) {
                long a = pq.poll();
                long b = pq.poll();
                long c = a + b;
                result += c;
                pq.offer(c);
            }

            System.out.println(result);
        }
    }
}
