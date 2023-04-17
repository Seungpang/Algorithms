package Programmers;
// 기사단원의 무기
public class PG136798 {

    public static void main(String[] args) {
        final PG136798 pg136798 = new PG136798();
        System.out.println(pg136798.solution(5, 3, 2));
    }

    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i=1; i<=number; i++) {
            int count = calculateNumberOfDivisors(i);
            if (count > limit) {
                answer += power;
            } else {
                answer += count;
            }
        }
        return answer;
    }

    public int calculateNumberOfDivisors(int num) {
        int cnt = 0;
        for (int i=1; i*i <=num; i++) {
            if (i*i == num) cnt++;
            else if (num % i == 0) {
                cnt+=2;
            }
        }
        return cnt;
    }
}
