package BJ;
// 애너그램

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No6996 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            boolean flag = isAnagrams(a, b);
            sb.append(a + " & " + b + " are ");
            if (flag) {
                sb.append("anagrams.");
            } else {
                sb.append("NOT anagrams.");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static boolean isAnagrams(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int[] check = new int[26];
        for (char c : a.toCharArray()) {
            check[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            check[c - 'a']--;
            if (check[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}