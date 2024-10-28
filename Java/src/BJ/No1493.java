package BJ;
// 박스 채우기

import java.util.Scanner;

public class No1493 {

    static long[] cubes = new long[20];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long length = sc.nextLong();
        long width = sc.nextLong();
        long height = sc.nextLong();

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int idx = sc.nextInt();
            long cnt = sc.nextLong();
            cubes[idx] = cnt;
        }

        long filledVolume = 0;
        long result = 0;

        for (int i = 19; i >= 0; i--) {
            filledVolume <<= 3;

            long cubeSide = 1L << i;
            long maxCubes = (length / cubeSide) * (width / cubeSide) * (height / cubeSide) - filledVolume;

            if (maxCubes > 0) {
                long useCubes = Math.min(cubes[i], maxCubes);
                filledVolume += useCubes;
                result += useCubes;
            }
        }

        if (filledVolume == length * width * height) {
            System.out.println(result);
        } else{
            System.out.println(-1);
        }
    }
}
