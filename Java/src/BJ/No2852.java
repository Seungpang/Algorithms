package BJ;

import java.util.Scanner;

public class No2852 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int round = 0;
        sc.nextLine();
        boolean check;
        int teamA = 0;
        int teamB = 0;
        int goalTime = 0;
        int time = 0;
        while (n-- > 0) {
            String[] s = sc.nextLine().split(" ");
            check = s[0].equals("1") ? true : false;
            goalTime = convertTime(s[1]);
            if (round > 0) {
                teamA += goalTime - time;
            }
            if (round < 0) {
                teamB += goalTime - time;
            }
            round += check ? 1 : -1;
            time = goalTime;
        }
        if (round > 0) {
            teamA += 2880 - time;
        }
        if (round < 0) {
            teamB += 2880 - time;
        }
        System.out.printf("%02d:%02d\n", teamA / 60, teamA % 60);
        System.out.printf("%02d:%02d\n", teamB / 60, teamB % 60);
    }


    static int convertTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
