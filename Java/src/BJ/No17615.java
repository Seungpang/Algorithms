package BJ;
// 볼 모으기

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No17615 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine().trim();

        if (!s.contains("R") || !s.contains("B")) {
            System.out.println(0);
            return;
        }

        int totalR = 0, totalB = 0;
        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if (c == 'R') totalR++;
            else totalB++;
        }

        int leftR = 0, leftB = 0;
        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if (c == 'R') leftR++;
            else break;
        }
        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if (c == 'B') leftB++;
            else break;
        }

        int rightR = 0, rightB = 0;
        for (int i = N - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == 'R') rightR++;
            else break;
        }
        for (int i = N - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == 'B') rightB++;
            else break;
        }

        int redCost = totalR - Math.max(leftR, rightR);
        int blueCost = totalB - Math.max(leftB, rightB);

        int ans = Math.min(redCost, blueCost);
        System.out.println(ans);
    }
}
