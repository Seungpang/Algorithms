package BJ;
// 비밀번호 발음하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No4659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while (!(input = br.readLine()).equals("end")) {
            StringBuilder sb = new StringBuilder();
            if (check(input) && check2(input) && check3(input)) {
                sb.append("<").append(input).append(">").append(" is acceptable.");
            } else {
                sb.append("<").append(input).append(">").append(" is not acceptable.");
            }
            System.out.println(sb);
        }
    }

    static boolean check(String password) {
        for (char c : password.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return true;
            }
        }
        return false;
    }

    static boolean check2(String password) {
        int prevJa = 0;
        int prevMo = 0;
        for (char c : password.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                prevMo++;
                prevJa = 0;
            } else {
                prevMo = 0;
                prevJa++;
            }
            if (prevJa == 3 || prevMo == 3) {
                return false;
            }
        }
        return true;
    }

    static boolean check3(String password) {
        char prev = 'a';
        int count = 0;
        for (char c : password.toCharArray()) {
            if (c == prev) {
                count++;
                if ((c != 'e' && c != 'o') && count == 2) {
                    return false;
                }
            } else {
                prev = c;
                count = 1;
            }
        }
        return true;
    }
}
