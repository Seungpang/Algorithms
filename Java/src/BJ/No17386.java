package BJ;
// 선분 교차 1

import java.util.Scanner;

public class No17386 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt(), y1 = sc.nextInt();
        int x2 = sc.nextInt(), y2 = sc.nextInt();
        int x3 = sc.nextInt(), y3 = sc.nextInt();
        int x4 = sc.nextInt(), y4 = sc.nextInt();

        int ccw1 = ccw(x1, y1, x2, y2, x3, y3);
        int ccw2 = ccw(x1, y1, x2, y2, x4, y4);
        int ccw3 = ccw(x3, y3, x4, y4, x1, y1);
        int ccw4 = ccw(x3, y3, x4, y4, x2, y2);

        if (ccw1 * ccw2 <= 0 && ccw3 * ccw4 <= 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        long result = (long) (x2 - x1) * (y3 - y1) - (long) (y2 - y1) * (x3 - x1);
        return Long.compare(result, 0);
    }
}
