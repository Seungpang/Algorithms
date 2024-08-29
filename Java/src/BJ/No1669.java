package BJ;
// 멍멍이 쓰다듬기

import java.util.Scanner;

public class No1669 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long X = sc.nextLong();
        long Y = sc.nextLong();

        long diff = Y - X;

        if (diff <= 3) {
            System.out.println(diff);
            return;
        }

        for (long bass = 1; ; bass++) {
            long sum = bass * bass + bass;
            if (sum < diff) {
                continue;
            }
            System.out.println(bass * 2 + (sum - bass >= diff ? -1 : 0));
            return;
        }
    }
}
