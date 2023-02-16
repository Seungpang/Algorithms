package Programmers;
// 크기가 작은 부분 문자열
public class PG147355 {

    public static void main(String[] args) {
        PG147355 pg147355 = new PG147355();
        System.out.println(pg147355.solution("10203", "15"));
    }

    public int solution(String t, String p) {
        int answer = 0;
        long parseValue = Long.parseLong(p);
        for (int left=0; left<t.length()-p.length()+1; left++) {
            int right = left + p.length();
            if (t.length() >= right) {
                answer += Long.parseLong(t.substring(left, right)) <= parseValue ? 1 : 0;
            }
        }
        return answer;
    }
}
