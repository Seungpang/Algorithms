package Programmers;
// 대충 만든 자판

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PG160586 {

    public static void main(String[] args) {
        final PG160586 pg160586 = new PG160586();
        System.out.println(
                Arrays.toString(pg160586.solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "AABB"})));
    }

    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> keys = new HashMap<>();
        for (int i=0; i<keymap.length; i++) {
            for (int j=0; j<keymap[i].length(); j++) {
                if (keys.getOrDefault(keymap[i].charAt(j), 100) > j+1) {
                    keys.put(keymap[i].charAt(j), j+1);
                }
            }
        }

        int[] answer = new int[targets.length];
        int count = 0;
        for (int i=0; i<targets.length; i++) {
            int sum = 0;
            for (int j=0; j<targets[i].length(); j++) {
                count = keys.getOrDefault(targets[i].charAt(j), -1);
                if (count == -1) {
                    sum = count;
                    break;
                }
                sum += count;
            }
            answer[i] = sum;
        }
        return answer;
    }
}
