package BJ;
// 투에-모스 문자열

import java.util.Scanner;

public class No18222 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long k = sc.nextLong();

        int count = countOneBits(k - 1);

        if (count % 2 == 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }

    static int countOneBits(long num) {
        int count = 0;

        while (num > 0) {
            if (num % 2 == 1) {
                count++;
            }

            num /= 2;
        }

        return count;
    }
}
