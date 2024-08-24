package BJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No21275 {

    private static final long MAX_VALUE = (1L << 63) - 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strA = sc.next();
        String strB = sc.next();

        List<long[]> results = new ArrayList<>();

        for (int a = 2; a <= 36; a++) {
            for (int b = 2; b <= 36; b++) {
                if (a == b) continue;

                long numA = convertToDecimal(strA, a);
                long numB = convertToDecimal(strB, b);

                if (numB != -1 && numA == numB) {
                    if (numA >= 0) {
                        results.add(new long[]{numA, a, b});
                    }
                }
            }
        }

        if (results.isEmpty()) {
            System.out.println("Impossible");
        } else if (results.size() == 1) {
            long[] result = results.get(0);
            System.out.printf("%d %d %d%n", result[0], result[1], result[2]);
        } else {
            System.out.println("Multiple");
        }
    }

    private static long convertToDecimal(String str, int base) {
        long result = 0;
        for (char c : str.toCharArray()) {
            int digit;
            if (c >= '0' && c <= '9') {
                digit = c - '0';
            } else if (c >= 'a' && c <= 'z') {
                digit = c - 'a' + 10;
            } else if (c >= 'A' && c <= 'Z') {
                digit = c - 'A' + 10;
            } else {
                return -1;
            }
            if (digit >= base) {
                return -1;
            }
            if (result > (MAX_VALUE - digit) / base) {
                return -1;
            }
            result = result * base + digit;
        }
        return result;
    }
}
