package BJ;
// 부분 문자열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No6550 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        while ((input = br.readLine()) != null) {
            String[] splitInput = input.split(" ");

            if (isSubstring(splitInput[0], splitInput[1])) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    static boolean isSubstring(String a, String b) {
        int j = 0;
        for (int i = 0; i < b.length(); i++) {
            if (j < a.length() && a.charAt(j) == b.charAt(i)) {
                j++;
            }
        }
        return j == a.length();
    }
}
