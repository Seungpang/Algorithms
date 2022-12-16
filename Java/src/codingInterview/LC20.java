package codingInterview;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC20 {

    public static void main(String[] args) {
        final LC20 lc20 = new LC20();
        System.out.println(lc20.isValid("(]"));
    }

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.empty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }
}
