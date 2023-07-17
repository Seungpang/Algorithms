package BJ;
// 그룹 단어 체커

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] check;
        boolean flag;
        int result = 0;
        for (int i = 0; i < N; i++) {
            check = new boolean[26];
            char before = '0';
            String word = br.readLine();
            flag = true;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (!check[c - 'a']) {
                    check[c - 'a'] = true;
                } else {
                    if (before == c) {
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
                before = c;
            }
            if (flag) {
                result++;
            }
        }
        System.out.println(result);
    }
}
