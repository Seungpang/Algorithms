package Programmers;
// 스킬트리

import java.util.HashMap;
import java.util.Map;

public class PG49993 {

    public static void main(String[] args) {
        final PG49993 pg49993 = new PG49993();
        System.out.println(pg49993.solution("CBD", new String[]{
                "BACDE", "CBADF", "AECB", "BDA"
        }));
    }

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Integer> sk = new HashMap<>();
        for (int i = 1; i <= skill.length(); i++) {
            sk.put(skill.charAt(i - 1), i);
        }

        for (int i=0; i<skill_trees.length; i++) {
            int idx = 1;
            int check = 0;
            for (int j = 0; j < skill_trees[i].length(); j++) {
                char c = skill_trees[i].charAt(j);
                if (sk.containsKey(c)) {
                    check = sk.get(c);
                    if (sk.get(c) == idx) {
                        idx++;
                    } else {
                        break;
                    }
                }
            }
            if (check == idx - 1) {
                answer++;
            }
        }
        return answer;
    }
}
