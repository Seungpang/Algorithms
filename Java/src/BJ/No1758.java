package BJ;
// 알바생 강호

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class No1758 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] customers = new Integer[N];
        for (int i = 0; i < N; i++) {
            customers[i] = sc.nextInt();
        }

        Arrays.sort(customers, Collections.reverseOrder());

        long result = 0;
        for (int i = 0; i < N; i++) {
            long tip = customers[i] - i;
            if (tip > 0) {
                result += tip;
            }
        }

        System.out.println(result);
    }
}
