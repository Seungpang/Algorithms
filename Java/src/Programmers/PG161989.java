package Programmers;

public class PG161989 {

    public static void main(String[] args) {
        final PG161989 pg161989 = new PG161989();
        System.out.println(pg161989.solution(8, 4, new int[]{2, 3, 6}));
    }

    public int solution(int n, int m, int[] section) {
        int answer = 0;

        int visitedSection = 0;
        for (int num : section) {
            if (visitedSection <= num) {
                visitedSection = num + m;
                answer++;
            }
        }
        return answer;
    }
}
