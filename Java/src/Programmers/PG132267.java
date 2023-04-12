package Programmers;
// 콜라 문제
public class PG132267 {

    public static void main(String[] args) {
        final PG132267 pg132267 = new PG132267();
        System.out.println(pg132267.solution(2, 1, 20));
    }

    public int solution(int a, int b, int n) {
        int answer = 0;
        while (n >= a) {
            answer += (n / a) * b;
            n = ((n / a) * b) + n % a;

        }
        return answer;
    }
}
