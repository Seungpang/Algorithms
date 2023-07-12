package BJ;
// 거꾸로 구구단

import java.util.Arrays;
import java.util.Scanner;

public class No13410 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[k+1];
        for (int i = 1; i <= k; i++) {
            int number = n * i;
            StringBuilder sb = new StringBuilder();
            sb.append(number);
            arr[i] = Integer.parseInt(sb.reverse().toString());
        }

        Arrays.sort(arr);
        System.out.println(arr[k]);
    }
}
