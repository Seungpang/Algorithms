package BJ;
// 두 배 더하기

import java.util.Scanner;

public class No12931 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;
        while (true) {
            boolean allZero = true;
            for (int i : arr) {
                if (i != 0) {
                    allZero = false;
                }
            }

            if (allZero) {
                break;
            }

            boolean even = true;
            for (int i : arr) {
                if (i % 2 != 0) {
                    even = false;
                }
            }

            if (even) {
                for (int i = 0; i < N; i++) {
                    arr[i] /= 2;
                }
                count++;
            } else {
                for (int i = 0; i < N; i++) {
                    if (arr[i] % 2 != 0) {
                        arr[i] -= 1;
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
