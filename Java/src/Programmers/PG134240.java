package Programmers;
// 푸드 파이트 대회
public class PG134240 {

    public static void main(String[] args) {
        final PG134240 pg134240 = new PG134240();
        System.out.println(pg134240.solution(new int[]{1, 3, 4, 6}));
    }

    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<food.length; i++) {
            sb.append(String.valueOf(i).repeat(Math.max(0, food[i] / 2)));
        }
        return sb.toString() + "0" + sb.reverse();
    }
}
