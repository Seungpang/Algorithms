package BJ;
// 보석 도둑

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1202 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Jewelry[] jewelries = new Jewelry[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewelries[i] = new Jewelry(M, V);
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewelries);
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long answer = 0;
        int jewelryIndex = 0;

        for (int bag : bags) {
            while (jewelryIndex < N && jewelries[jewelryIndex].weight <= bag) {
                pq.offer(jewelries[jewelryIndex].value);
                jewelryIndex++;
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }

    static class Jewelry implements Comparable<Jewelry> {
        int weight;
        int value;

        public Jewelry(final int weight, final int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(final Jewelry o) {
            return this.weight - o.weight;
        }
    }
}
