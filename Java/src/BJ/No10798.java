package BJ;
// 세로읽기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] chars = new char[5][15];
        int max = 0;

        for (int i = 0; i < chars.length; i++) {
            String str = br.readLine();
            max = Math.max(str.length(), max);

            for (int j = 0; j < str.length(); j++) {
                chars[i][j] = str.charAt(j);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                if (chars[j][i] == '\0') {
                    continue;
                }
                result.append(chars[j][i]);
            }
        }

        System.out.println(result);
    }
}
