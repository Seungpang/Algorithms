package Programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PG17677 {

    public static void main(String[] args) {
        final PG17677 pg17677 = new PG17677();
        System.out.println(pg17677.solution("FRANCE", "french"));
        System.out.println(pg17677.solution("handshake", "shake hands\t"));
        System.out.println(pg17677.solution("aa1+aa2", "AAAA12"));
        System.out.println(pg17677.solution("E=M*C^2", "e=m*c^2"));
    }

    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Set<String> set = new HashSet<>();
        validateStr(str1, map1, set);
        validateStr(str2, map2, set);

        int total = 0;
        for (String s : set) {
            total += Math.max(map1.getOrDefault(s, 0), map2.getOrDefault(s, 0));
        }

        int answer = 0;
        for (String s : map2.keySet()) {
            if (map1.containsKey(s)) {
                answer += Math.min(map1.get(s), map2.get(s));
            }
        }

        if (total == 0) {
            return 65536;
        }
        return answer * 65536 / total;
    }

    private static void validateStr(final String str, final Map<String, Integer> map, final Set<String> set) {
        for (int i = 0; i < str.length() - 1; i++) {
            String s = str.substring(i, i + 2);
            if (Character.isAlphabetic(s.charAt(0)) && Character.isAlphabetic(s.charAt(1))) {
                map.put(s, map.getOrDefault(s, 0) + 1);
                set.add(s);
            }
        }
    }
}
