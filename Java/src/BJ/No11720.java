package BJ;
// 숫자의 합

import java.util.Scanner;

public class No11720 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String number = sc.next();

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += Integer.parseInt(String.valueOf(number.charAt(i)));
        }
        System.out.println(result);
    }
}
