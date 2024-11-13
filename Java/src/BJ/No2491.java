package BJ;
// 수열

import java.util.Scanner;

public class No2491  {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        int maxLength = 1;
        int incLength = 1;
        int decLength = 1;
        for (int i = 1; i < N; i++) {
            if (nums[i] >= nums[i - 1]) {
                incLength++;
            } else {
                incLength = 1;
            }

            if (nums[i] <= nums[i - 1]) {
                decLength++;
            } else {
                decLength = 1;
            }

            maxLength = Math.max(maxLength, Math.max(incLength, decLength));
        }

        System.out.println(maxLength);
    }
}
