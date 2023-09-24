package BJ;
// 서로 다른 부분 문자열의 개수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class No11478 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        Set<String> set = new HashSet<>();
        for (int i = 1; i <= S.length(); i++) {
            int idx = 0;
            for (int j = i; j <= S.length(); j++) {
                set.add(S.substring(idx, j));
                idx++;
            }
        }

        System.out.println(set.stream().count());
    }
}
