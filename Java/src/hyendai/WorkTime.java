package hyendai;

import java.util.Scanner;

public class WorkTime {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        while (sc.hasNextLine()) {
            String dailyWordTime = sc.nextLine();
            String[] workTime = dailyWordTime.split(" ");
            result -= convertToMinutes(workTime[0].split(":"));
            result += convertToMinutes(workTime[1].split(":"));
        }
        System.out.println(result);
    }

    private static int convertToMinutes(String[] times) {
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
}
