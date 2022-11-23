package BJ;
//잃어버린 괄호
//그리디

import java.util.Scanner;

public class No1541 {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        final String[] split = str.split("-");
        int result = 0;
        for (int i = 0; i < split.length; i++) {
            int temp = plusSum(split[i]);
            if (i == 0) {
                result = result + temp;
            } else {
                result = result - temp;
            }
        }
        System.out.println(result);
    }

    private static int plusSum(final String s) {
        int sum = 0;
        final String[] split = s.split("[+]");
        for (int i = 0; i < split.length; i++) {
            sum += Integer.parseInt(split[i]);
        }
        return sum;
    }
}
