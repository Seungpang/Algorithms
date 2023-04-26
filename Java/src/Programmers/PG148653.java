package Programmers;
// 마법의 엘리베이터
public class PG148653 {

    public static void main(String[] args) {
        final PG148653 a = new PG148653();
        System.out.println(a.solution(16)); // 6
    }

    public int solution(int storey) {
        int answer = 0;
        while (storey != 0) {
            int n = storey % 10;
            storey = storey / 10;
            if (n > 5 || (n == 5 && storey % 10 >= 5)) {
                answer += 10 - n;
                storey += 1;
            } else {
                answer += n;
            }
        }
        return answer;
    }
}
