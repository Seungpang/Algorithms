package Programmers;
// 문자열 나누기
public class PG140108 {

    public static void main(String[] args) {
        final PG140108 pg140108 = new PG140108();
        System.out.println(pg140108.solution("abracadabra")); // 6
    }

    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        int idx = 0;
        while (idx < n) {
            char x = s.charAt(idx);
            int xCount = 1;
            int otherCount = 0;
            while (idx + 1 <n && xCount != otherCount) {
                idx++;
                if (s.charAt(idx) == x) {
                    xCount++;
                } else {
                    otherCount++;
                }
            }
            answer++;
            idx++;
        }
        return answer;
    }
}
