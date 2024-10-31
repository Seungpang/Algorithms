package BJ;
// 귀찮음

import java.util.Arrays;
import java.util.Scanner;

public class No16208 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sticks = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sticks[i] = sc.nextInt();
            sum += sticks[i];
        }

        Arrays.sort(sticks);

        long result = 0;
        for (int i = 0; i < n - 1; i++) {
            sum -= sticks[i];
            result += (long) sum * sticks[i];
        }

        System.out.println(result);
    }
}
