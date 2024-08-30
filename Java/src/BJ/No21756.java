package BJ;
// 지우개

import java.util.Scanner;

public class No21756 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int result = 1;
        while (result * 2 <= n) {
            result *= 2;
        }

        System.out.println(result);
    }
}
