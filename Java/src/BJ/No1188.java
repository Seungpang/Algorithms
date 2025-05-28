package BJ;
// 음식 평론가

import java.util.Scanner;

public class No1188 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M  = sc.nextInt();
        int num = gcd(N, M);
        System.out.println(M - num);
    }

    static int gcd(int a, int b){
        int c = 0;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
