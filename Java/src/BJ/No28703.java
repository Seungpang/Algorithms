package BJ;
// Double It

import java.util.Arrays;
import java.util.Scanner;

public class No28703 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = Arrays.stream(arr).max().getAsInt();

        for (int i = 0; i < n; i++) {
            while (arr[i] * 2 <= max) {
                arr[i] = arr[i] * 2;
            }
        }

        Arrays.sort(arr);

        int ans = arr[n - 1] - arr[0];
        for (int i = 1; i < n; i++) {
            ans = Math.min(ans, 2 * arr[i - 1] - arr[i]);
        }

        System.out.println(ans);
    }
}
