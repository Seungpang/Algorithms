package BJ;
// 회의실배정

import java.util.Arrays;
import java.util.Scanner;

public class No1931 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        MeetingRoom[] meetingRooms = new MeetingRoom[n];
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            meetingRooms[i] = new MeetingRoom(start, end);
        }

        Arrays.sort(meetingRooms);

        int meetingEndTime = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (meetingEndTime > meetingRooms[i].start) {
                continue;
            }
            result++;
            meetingEndTime = meetingRooms[i].end;
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
            if (this.end - o.end == 0) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }
}
