package BJ;
// 내 선물을 받아줘 2

import java.util.Scanner;

public class No15886 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] map = new char[n];
        sc.nextLine();
        String s = sc.nextLine();
        for (int i = 0; i < n; i++) {
            map[i] = s.charAt(i);
        }

        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            if (map[i] == 'E' && map[i + 1] == 'W') {
                result++;
            }
        }
        System.out.println(result);
    }
}
