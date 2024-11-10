package BJ;
// 백설 공주와 일곱 난쟁이

import java.util.Scanner;

public class No3040 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                int result = sum - arr[i] - arr[j];
                if (result == 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    i = 9;
                    break;
                }
            }
        }

        for (int i : arr) {
            if (i != 0) {
                System.out.println(i);
            }
        }
    }
}
