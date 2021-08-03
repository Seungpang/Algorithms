package BJ;

import java.util.Arrays;
import java.util.Scanner;

public class No2309 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[9];
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        boolean check = false;
        for (int i = 0; i < 9; i++) {
            if (check) break;
            for (int j = 0; j< 9; j++) {
                if (i == j) continue;
                if (sum - arr[i] - arr[j] == 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    check = true;
                    break;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if (arr[i] != 0) {
                System.out.println(arr[i]);
            }
        }
    }
}
