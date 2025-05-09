package BJ;
// 다각형의 면적

import java.util.Scanner;

public class No2166 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long[] x = new long[N];
        long[] y = new long[N];

        for (int i = 0; i < N; i++) {
            x[i] = sc.nextLong();
            y[i] = sc.nextLong();
        }

        double area = 0;
        for (int i = 0; i < N; i++) {
            int j = (i + 1) % N;
            area += x[i] * y[j] - y[i] * x[j];
        }

        area = Math.abs(area) / 2.0;

        System.out.printf("%.1f\n", area);
    }
}
