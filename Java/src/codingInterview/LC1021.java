package codingInterview;

public class LC1021 {

    public static void main(String[] args) {
        final LC1021 lc1021 = new LC1021();
        System.out.println(lc1021.removeOuterParentheses("(()())(())")); //"()()()"
        System.out.println(lc1021.removeOuterParentheses("(()())(())(()(()))")); //"()()()()(())"

    }

    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int opened = 0;
        for (char c : s.toCharArray()) {
            if (c == '(' && opened++ > 0) {
                sb.append(c);
            }
            if (c == ')' && opened-- > 1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
