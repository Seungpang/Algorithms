package Programmers;
// 3진법 뒤집기
public class PG68935 {

    public static void main(String[] args) {
        final PG68935 pg68935 = new PG68935();
        System.out.println(pg68935.solution(45));
    }

    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(n, 3));
        sb.reverse();
        return Integer.parseInt(sb.toString(), 3);
    }
}
