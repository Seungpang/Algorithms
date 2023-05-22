package BJ;
// 센서

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class No2212 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] sensor = new int[n];
        for (int i = 0; i < n; i++) {
            sensor[i] = sc.nextInt();
        }

        Arrays.sort(sensor);

        Integer[] diff = new Integer[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = sensor[i + 1] - sensor[i];
        }

        Arrays.sort(diff, Collections.reverseOrder());
        int sum = 0;
        for (int i = k - 1; i < n - 1; i++) {
            sum += diff[i];
        }
        System.out.println(sum);
    }
}
