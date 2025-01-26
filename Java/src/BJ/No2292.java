package BJ;
// 벌집

import java.util.Scanner;

public class No2292 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int layer = 1;
        int maxNum = 1;

        while (n > maxNum) {
            maxNum += 6 * layer;
            layer++;
        }

        System.out.println(layer);
    }
}
