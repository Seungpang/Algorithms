package BJ;
// 평균

import java.util.Arrays;
import java.util.Scanner;

public class No1546 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
        }

        Arrays.sort(scores);

        int M = scores[N - 1];
        double result = 0;
        for (int i = 0; i < N; i++) {
            result += ((double) scores[i] / M) * 100;
        }

        result /= N;

        System.out.println(result);
    }
}
