package BJ;
// 고냥이

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class No16472 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String input = sc.next();

        Map<Character, Integer> charCount = new HashMap<>();
        int maxLen = 0;
        int start = 0;

        for (int end = 0; end < input.length(); end++) {
            char currChar = input.charAt(end);
            charCount.put(currChar, charCount.getOrDefault(currChar, 0) + 1);

            while (charCount.size() > N) {
                char startChar = input.charAt(start);
                charCount.put(startChar, charCount.get(startChar) - 1);

                if (charCount.get(startChar) == 0) {
                    charCount.remove(startChar);
                }
                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);
        }

        System.out.println(maxLen);
    }
}
