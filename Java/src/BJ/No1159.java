package BJ;
// 농구 경기

import java.util.Arrays;
import java.util.Scanner;

public class No1159 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] players = new String[N];
        for (int i = 0; i < N; i++) {
            players[i] = sc.nextLine();
        }

        Arrays.sort(players);
        int[] counts = new int[26];

        for (String player : players) {
            counts[player.charAt(0) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (counts[i] >= 5) {
                sb.append((char) (i + 'a'));
            }
        }

        System.out.println(sb.length() == 0 ? "PREDAJA" : sb);
    }
}
