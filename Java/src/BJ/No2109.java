package BJ;
// 순회강연

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No2109 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(day, price));
        }

        Collections.sort(lectures);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int maxPay = 0;
        for (Lecture lecture : lectures) {
            pq.offer(lecture.pay);
            maxPay += lecture.pay;

            if (pq.size() > lecture.day) {
                maxPay -= pq.poll();
            }
        }

        System.out.println(maxPay);
    }

    static class Lecture implements Comparable<Lecture> {

        int day;
        int pay;

        public Lecture(int day, int pay) {
            this.day = day;
            this.pay = pay;
        }

        @Override
        public int compareTo(Lecture o) {
            return this.day - o.day;
        }
    }
}
