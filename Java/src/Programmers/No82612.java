package Programmers;

public class No82612 {

    public long solution(int price, int money, int count) {
        long answer = 0L;
        long sum = 0L;

        for (int i = 1; count >= i; i++) {
            sum += price * i;
        }
        answer = money - sum;
        if (answer > 0) {
            return 0;
        }
        return Math.abs(answer);
    }
}
