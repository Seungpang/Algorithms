package Programmers;

public class PG140107 {

    public static void main(String[] args) {
        final PG140107 pg140107 = new PG140107();
        System.out.println(pg140107.solution(1, 5));
    }

    public long solution(int k, int d) {
        long answer = 0;
        for (long i=0; i<=d/k; i++) {
            long x = i * k;
            long y = (long) (Math.sqrt(Math.pow(d,2) - Math.pow(x,2)) / k);
            answer += y + 1;
        }
        return answer;
    }
}
