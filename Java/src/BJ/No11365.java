package BJ;
// !밀비 급일

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11365 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";

        while (true) {
            StringBuilder sb = new StringBuilder();
            s = br.readLine();
            if (s.equals("END")) {
                break;
            }
            sb.append(s);
            System.out.println(sb.reverse());
        }
    }
}
