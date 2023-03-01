package Programmers;

public class PG12913 {

    public static void main(String[] args) {
        final PG12913 pg12913 = new PG12913();
        System.out.println(pg12913.solution(new int[][]{
                {1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}
        }));
    }

    int solution(int[][] land) {
        int answer = 0;

        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }

        for (int score : land[land.length-1]) {
            answer = Math.max(score, answer);
        }

        return answer;
    }
}
