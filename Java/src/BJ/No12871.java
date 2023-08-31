package BJ;
// 무한 문자열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No12871 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        String ss = "", tt = "";
        for (int i = 0; i < t.length(); i++) {
            ss += s;
        }
        for (int i = 0; i < s.length(); i++) {
            tt += t;
        }

        if (ss.equals(tt)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
