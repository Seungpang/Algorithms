package BJ;
// 경고

import java.util.Scanner;

public class No3029 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String currentTime = sc.nextLine();
        String throwTime = sc.nextLine();

        int currentSeconds = convertToSeconds(currentTime);
        int throwSeconds = convertToSeconds(throwTime);

        int waitSeconds = calculateWaitTime(currentSeconds, throwSeconds);

        System.out.println(formatTime(waitSeconds));
    }

    private static int convertToSeconds(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }

    private static int calculateWaitTime(int current, int throwTime) {
        int wait = throwTime - current;
        if (wait <= 0) {
            wait += 24 * 3600;
        }
        return Math.min(wait, 24 * 3600);
    }

    private static String formatTime(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, secs);
    }
}
