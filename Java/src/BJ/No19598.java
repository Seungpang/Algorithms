package BJ;
// 최소 회의실 개수

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class No19598 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        MeetingRoom[] meetingRooms = new MeetingRoom[n];
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            meetingRooms[i] = new MeetingRoom(start, end);
        }

        Arrays.sort(meetingRooms);

        pq.offer(meetingRooms[0].end);
        int result = 1;

        for (int i = 1; i < n; i++) {
            while (!pq.isEmpty() && pq.peek() <= meetingRooms[i].start) {
                pq.poll();
            }
            pq.offer(meetingRooms[i].end);
            System.out.println(pq);
            result = Math.max(result, pq.size());
        }
        System.out.println(result);
    }

    static class MeetingRoom implements Comparable<MeetingRoom> {
        int start;
        int end;

        public MeetingRoom(final int start, final int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(final MeetingRoom o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
}
