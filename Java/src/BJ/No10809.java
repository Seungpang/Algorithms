package BJ;
// 알파벳 찾기

import java.util.Arrays;
import java.util.Scanner;

public class No10809 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int size = s.length();
        int[] alpha = new int[26];
        Arrays.fill(alpha, -1);

        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            if (alpha[c - 'a'] == -1) {
                alpha[c - 'a'] = i;
            }
        }

        for (int num : alpha) {
            System.out.print(num + " ");
        }
    }
}
