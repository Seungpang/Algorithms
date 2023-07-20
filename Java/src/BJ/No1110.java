package BJ;
// 더하기 사이클

import java.util.Scanner;

public class No1110 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 0;
        int temp = N;
        while (true) {
            int a = temp / 10;
            int b = temp % 10;
            temp = (b * 10) + (a + b) % 10;
            count++;
            if (temp == N) {
                break;
            }
        }

        System.out.println(count);
    }
}
