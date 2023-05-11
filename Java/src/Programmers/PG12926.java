package Programmers;

public class PG12926 {

    public String solution(String s, int n) {
        String answer = "";
        char[] arr = new char[s.length()];
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)!=' ') {
                if (s.charAt(i)+n>=123 && s.charAt(i)>96 && s.charAt(i)<123) {
                    arr[i]=(char)(s.charAt(i)+n-26);
                } else if (s.charAt(i)+n>=91 && s.charAt(i)>64 && s.charAt(i)<91) {
                    arr[i]=(char)(s.charAt(i)+n-26);
                } else {
                    arr[i]=(char)(s.charAt(i)+n);
                }
            }
            answer+=arr[i];
        }

        return answer;
    }

    public String solution2(String s, int n) {
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
