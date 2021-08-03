package Programmers;

public class Lv1_문자열을_정수로_바꾸기 {

    public static void main(String[] args) {
        Lv1_문자열을_정수로_바꾸기 sol = new Lv1_문자열을_정수로_바꾸기();
        System.out.println(sol.solution("1234"));
    }

    public int solution(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '-')
                sb.append('-');
            else
                sb.append(ch);
        }
        return Integer.parseInt(sb.toString());
    }
}
