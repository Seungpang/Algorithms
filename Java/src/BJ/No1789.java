package BJ;
// 수들의 합

import java.util.Scanner;

public class No1789 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();
        long sum = 0;
        int count = 0;

        for (int i = 1; ; i++) {
            if (sum > S) {
                break;
            }
            sum += i;
            count++;
        }
        System.out.println(count - 1);
    }
}
