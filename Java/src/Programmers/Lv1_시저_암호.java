package Programmers;

public class Lv1_시저_암호 {

    public static void main(String[] args) {
        Lv1_시저_암호 sol = new Lv1_시저_암호();
        System.out.println(sol.solution("AB", 1));
    }

    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (ch + n > 'z')
                    sb.append((char)(ch + n - 26));
                else
                    sb.append((char)(ch + n));
            } else if (ch >= 'A' && ch <= 'Z') {
                if (ch + n > 'Z')
                    sb.append((char)(ch + n - 26));
                else
                    sb.append((char)(ch + n));
            } else
                sb.append((char)ch);
        }

        return sb.toString();
    }
}
