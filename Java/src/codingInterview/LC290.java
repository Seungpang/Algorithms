package codingInterview;

import java.util.HashMap;
import java.util.Map;

public class LC290 {

    public static void main(String[] args) {

        LC290 lc290 = new LC290();
        System.out.println(lc290.wordPattern("abba", "dog cat cat dog"));
        System.out.println(lc290.wordPattern("abba", "dog dog dog dog"));
    }

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> mapChar = new HashMap<>();
        Map<String, Character> mapWord = new HashMap<>();
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            if (!mapChar.containsKey(c)) {
                if (mapWord.containsKey(w)) {
                    return false;
                } else {
                    mapChar.put(c, w);
                    mapWord.put(w, c);
                }
            } else {
                String mappedWord = mapChar.get(c);
                if (!mappedWord.equals(w)) {
                    return false;
                }
            }
        }
        return true;
    }
}
