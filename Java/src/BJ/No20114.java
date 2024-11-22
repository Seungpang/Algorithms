package BJ;
// 미아 노트

import java.util.Arrays;
import java.util.Scanner;

public class No20114 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int H = sc.nextInt();
        int W = sc.nextInt();
        char[] word = new char[N];
        Arrays.fill(word, '?');
        for (int i = 0; i < H; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < W; k++) {
                    char c = s.charAt(W * j + k);
                    if (c != '?') {
                        word[j] = c;
                        break;
                    }
                }
            }
        }

        System.out.println(word);
    }
}
