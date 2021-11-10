package Programmers;
//나머지가 1이 되는 수 찾기

public class PG87389 {

    public static void main(String[] args) {
        PG87389 a = new PG87389();
        System.out.println(a.solution(10));
    }

    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 1) {
                answer =  i;
                break;
            }
        }
        return answer;
    }
}
