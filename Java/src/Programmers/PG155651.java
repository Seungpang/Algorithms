package Programmers;

import java.util.Arrays;

public class PG155651 {

    public static void main(String[] args) {
        final PG155651 pg155651 = new PG155651();
        pg155651.solution(
                new String[][]{
                        {"09:10", "10:10"}, {"10:20", "12:20"}
                }
        );
    }

    public int solution(String[][] book_time) {
        int n = book_time.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i=0; i<n; i++) {
            starts[i] = convertTime(book_time[i][0]);
            ends[i] = convertTime(book_time[i][1]) + 10;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int usedRoom = 0;
        int endsIndex = 0;
        for (int i=0; i<n; i++) {
            if (starts[i] < ends[endsIndex]) {
                usedRoom++;
            } else {
                endsIndex++;
            }
        }
        return usedRoom;
    }

    private int convertTime(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
}
