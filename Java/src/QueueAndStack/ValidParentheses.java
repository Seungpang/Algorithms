package QueueAndStack;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String exp="()[]{}";

        System.out.println(isValid(exp));
    }

    public static boolean isValid(String s){
        if(s.length()%2 !=0)
            return false;
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            switch (s.charAt(i)){
                case ')':
                    if(!stack.isEmpty() && stack.peek()=='(') stack.pop();
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.peek()=='{') stack.pop();
                    break;
                case ']':
                    if(!stack.isEmpty() && stack.peek()=='[') stack.pop();
                    break;
                default:
                    stack.push(s.charAt(i));
                    break;
            }
        }
        return stack.empty();
    }
}
