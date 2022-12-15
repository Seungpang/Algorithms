package codingInterview;

import java.util.Arrays;

public class LC253 {

    public static void main(String[] args) {
        final LC253 lc253 = new LC253();
        System.out.println(lc253.minMeetingRooms(
                new int[][]{
                        {0, 30},
                        {5, 10},
                        {15, 20}
                }
        ));
    }

    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int usedRoom = 0;
        int endsIndex = 0;
        for (int i = 0; i < n; i++) {
            if (starts[i] < ends[endsIndex]) {
                usedRoom++;
            } else {
                endsIndex++;
            }
        }
        return usedRoom;
    }
}
