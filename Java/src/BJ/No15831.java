package BJ;
// 준표의 조약돌

import java.util.Scanner;

public class No15831 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();
        int W = sc.nextInt();
        String line = sc.next();

        int white = 0;
        int black = 0;
        int result = 0;

        int left = 0;
        for (int right = 0; right < N; right++) {
            if (line.charAt(right) == 'W') {
                white++;
            } else {
                black++;
            }

            while (black > B) {
                if (line.charAt(left) == 'W') {
                    white--;
                } else {
                    black--;
                }
                left++;
            }

            if (white >= W) {
                result = Math.max(result, right - left + 1);
            }
        }

        System.out.println(result);
    }
}
