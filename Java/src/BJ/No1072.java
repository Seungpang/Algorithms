package BJ;
// 게임

import java.util.Scanner;

public class No1072 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = calculatePercent(x, y);

        int left = 0;
        int right = 1000000000;

        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (calculatePercent(x + mid, y + mid) != z) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }

    static int calculatePercent(int x, int y) {
        return (int) ((long) y * 100 / x);
    }
}
