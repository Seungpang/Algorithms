package BJ;
//홀짝 칵테일

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class No21312 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        List<Integer> cocktails = Arrays.asList(A, B, C, A * B, B * C, A * C, A * B * C);
        Collections.sort(cocktails);

        for (int i = cocktails.size() - 1; i >= 0; i--) {
            if (cocktails.get(i) % 2 != 0) {
                System.out.println(cocktails.get(i));
                return;
            }
        }
        System.out.println(cocktails.get(cocktails.size()-1));
    }
}
