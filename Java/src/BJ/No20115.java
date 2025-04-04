package BJ;
// 에너지 드링크

import java.util.Arrays;
import java.util.Scanner;

public class No20115 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double[] drinks = new double[N];
        for (int i = 0; i < N; i++) {
            drinks[i] = sc.nextDouble();
        }

        Arrays.sort(drinks);

        double max = drinks[N - 1];
        for (int i = 0; i < N - 1; i++) {
            max += drinks[i] / 2;
        }

        System.out.println(max);
    }
}
