package com.company.level1;

public class 시저_암호 {
    public static void main(String[] args) {
        시저_암호 sol = new 시저_암호();
        String s = "AB";
        int n = 1;
        System.out.println(sol.solution(s,n));
    }
    public String solution(String s, int n) {
        String answer = "";
        n = n%26;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isLowerCase(ch)){
                ch = (char)((ch - 'a' + n) % 26 + 'a');
            }else if(Character.isUpperCase(ch)){
                ch = (char)((ch - 'A' + n) % 26 + 'A');
            }

            answer += ch;
        }
        return answer;
    }
}
