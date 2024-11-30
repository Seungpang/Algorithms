package BJ;
// 배부른 마라토너

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class No10546 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<String, Integer> participants = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String participant = sc.next();
            participants.put(participant, participants.getOrDefault(participant, 0) + 1);
        }

        for (int i = 0; i < N - 1; i++) {
            String participant = sc.next();
            participants.put(participant, participants.get(participant) - 1);
        }

        for (String key : participants.keySet()) {
            if (participants.get(key) > 0) {
                System.out.println(key);
                break;
            }
        }
    }
}
