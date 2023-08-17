package BJ;
// 뒤집기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int oneCount = 0;
        int zeroCount = 0;

        if (S.charAt(0) == '0') {
            zeroCount++;
        } else {
            oneCount++;
        }

        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) != S.charAt(i - 1)) {
                if (S.charAt(i) == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
        }

        System.out.println(Math.min(oneCount, zeroCount));
    }
}
