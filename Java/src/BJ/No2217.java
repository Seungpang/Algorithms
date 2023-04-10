package BJ;
// 로프

import java.util.Arrays;
import java.util.Scanner;

public class No2217 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] rope = new int[n];
        for (int i = 0; i < n; i++) {
            rope[i] = sc.nextInt();
        }
        Arrays.sort(rope);

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, rope[n - i] * i);
        }
        System.out.println(result);
    }
}
