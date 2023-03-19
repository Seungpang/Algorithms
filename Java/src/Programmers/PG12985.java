package Programmers;

public class PG12985 {

    public static void main(String[] args) {
        final PG12985 pg12985 = new PG12985();
        System.out.println(pg12985.solution(8, 4, 5));
    }

    public int solution(int n, int a, int b)
    {
        int answer = 0;
        while (a != b) {
            n /= 2;
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            answer++;
        }
        return answer;
    }
}
