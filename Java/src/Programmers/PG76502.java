package Programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PG76502 {

    public static void main(String[] args) {
        final PG76502 pg76502 = new PG76502();
        System.out.println(pg76502.solution("[](){}"));
        System.out.println(pg76502.solution("{{{{{{"));
    }

    public int solution(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('(', ')');
        map.put('{', '}');

        char[] word = s.toCharArray();
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            boolean isPossible = true;
            for (int j=0; j<s.length(); j++) {
                if (word[j] == '[' || word[j] == '(' || word[j] == '{') {
                    stack.push(word[j]);
                } else if (!stack.isEmpty() && map.get(stack.peek()) == word[j]) {
                    stack.pop();
                } else {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible && stack.isEmpty()) {
                answer++;
            }

            int len = word.length;
            char temp = word[len - 1];
            for (int k = len - 1; k > 0; k--) {
                word[k] = word[k-1];
            }
            word[0] = temp;
        }
        return answer;
    }
}
