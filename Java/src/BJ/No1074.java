package BJ;
// Z

import java.util.Scanner;

public class No1074 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(findOrder(N, r, c));
    }
    
    public static int findOrder(int N, int r, int c) {
        if (N == 0) return 0;

        int size = 1 << (N - 1);
        int quadrant = findQuadrant(r, c, size);
        int subOrder = findOrder(N - 1, r % size, c % size);
        return quadrant * size * size + subOrder;
    }

    static int findQuadrant(int r, int c, int size) {
        if (r < size) {
            if (c < size) return 0;
            else return 1;
        } else {
            if (c < size) return 2;
            else return 3;
        }
    }
}
