package BJ;
// 4와 7

import java.util.Scanner;

public class No2877 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        long length = 1;
        long count = 2;

        while (K > count) {
            K -= count;
            length++;
            count *= 2;
        }

        StringBuilder res = new StringBuilder();
        K--;

        for (int i = 0; i < length; i++) {
            if (K % 2 == 0) {
                res.append("4");
            } else {
                res.append("7");
            }
            K /= 2;
        }

        System.out.println(res.reverse());
    }
}
