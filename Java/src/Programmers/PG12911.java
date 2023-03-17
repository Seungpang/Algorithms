package Programmers;

public class PG12911 {

    public static void main(String[] args) {
        final PG12911 pg12911 = new PG12911();
        System.out.println(pg12911.solution(78));
    }

    public int solution(int n) {
        int answer = 0;
        int target = Integer.bitCount(n);

        while (true) {
            n++;
            if (target == Integer.bitCount(n)) {
                answer = n;
                break;
            }
        }
        return answer;
    }
}
