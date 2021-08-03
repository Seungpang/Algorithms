package BJ;

import java.util.Scanner;

public class No17427 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long g = 0;

        for (int i=1; i<=n; i++) {
            g += n / i * i;
        }

        System.out.println(g);
    }
}
