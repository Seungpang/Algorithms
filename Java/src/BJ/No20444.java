package BJ;
// 색종이와 가위

import java.util.Scanner;

public class No20444 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();

        long left = 0;
        long right = n - 1;
        while (left <= right) {
            long row = (left + right) / 2;
            long col = n - row;

            long total = cutPaper(row, col);
            if (total == k) {
                System.out.println("YES");
                return;
            } else if (total > k) {
                right = row - 1;
            } else {
                left = row + 1;
            }
        }
        System.out.println("NO");
    }

    static long cutPaper(long row, long col) {
        return (row + 1) * (col + 1);
    }
}
