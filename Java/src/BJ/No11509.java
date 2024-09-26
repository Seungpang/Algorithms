package BJ;
// 풍선 맞추기

import java.util.Scanner;

public class No11509 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] balloons = new int[N];

        for (int i = 0; i < N; i++) {
            balloons[i] = sc.nextInt();
        }

        int[] arrows = new int[1000001];
        int result = 0;
        for (int i = 0; i < N; i++) {
            int h = balloons[i];
            if (arrows[h] > 0) {
                arrows[h]--;
                arrows[h - 1]++;
            } else {
                result++;
                arrows[h - 1]++;
            }
        }

        System.out.println(result);
    }
}
