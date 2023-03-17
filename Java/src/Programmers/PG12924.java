package Programmers;

public class PG12924 {

    public static void main(String[] args) {
        final PG12924 pg12924 = new PG12924();
        System.out.println(pg12924.solution(15));
    }

    int answer;

    public int solution(int n) {
        answer = 0;
        for (int i=1; i<=n; i++) {
            recursive(0, i, n);
        }
        return answer;
    }

    public void recursive(int sum, int num, int target) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            answer++;
        }
        recursive(sum + num, num+1, target);
    }
}
