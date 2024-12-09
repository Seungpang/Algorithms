package BJ;
// 디지털시계

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1942 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            String[] input = br.readLine().split(" ");
            String start = input[0];
            String end = input[1];
            System.out.println(countMultiplesOfThree(start, end));
        }
    }

    private static int timeToSeconds(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }

    private static int secondsToClockInteger(int seconds) {
        int hours = seconds / 3600;
        seconds %= 3600;
        int minutes = seconds / 60;
        seconds %= 60;
        return hours * 10000 + minutes * 100 + seconds;
    }

    private static int countMultiplesOfThree(String startTime, String endTime) {
        int startSeconds = timeToSeconds(startTime);
        int endSeconds = timeToSeconds(endTime);

        if (endSeconds < startSeconds) {
            return countMultiplesInRange(startSeconds, 24*3600-1) +
                    countMultiplesInRange(0, endSeconds);
        }

        return countMultiplesInRange(startSeconds, endSeconds);
    }

    private static int countMultiplesInRange(int startSeconds, int endSeconds) {
        int count = 0;
        for (int i = startSeconds; i <= endSeconds; i++) {
            int clockInt = secondsToClockInteger(i);
            if (clockInt % 3 == 0) {
                count++;
            }
        }
        return count;
    }
}
