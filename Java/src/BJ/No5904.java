package BJ;
// Moo 게임

import java.util.Scanner;

public class No5904 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        System.out.println(findMooChar(N));
    }

    static char findMooChar(long n) {
        long length = 3;
        int k = 0;

        while (length < n) {
            k++;
            length = 2 * length + (k + 3);
        }

        while (k > 0) {
            long prevLength = (length - (k + 3)) / 2;
            long middleStart = prevLength + 1;
            long middleEnd = prevLength + (k + 3);

            if (n <= prevLength) {
                length = prevLength;
                k--;
            } else if (n <= middleEnd) {
                if (n == middleStart) {
                    return 'm';
                } else {
                    return 'o';
                }
            } else {
                n -= (prevLength + (k + 3));
                length = prevLength;
                k--;
            }
        }

        return "moo".charAt((int) (n - 1));
    }
}
