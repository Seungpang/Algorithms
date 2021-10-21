package WeeklyChallenge;

public class Week3 {

    public static void main(String[] args) {
        Week3 a = new Week3();
        int[][] game_board = {
            {1, 1, 0, 0, 1, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 1, 1, 0, 0, 1},
            {1, 1, 0, 1, 1, 1},
            {1, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 0, 0}
        };
        int[][] table = {
            {1, 0, 0, 1, 1, 0},
            {1, 0, 1, 0, 1, 0},
            {0, 1, 1, 0, 1, 1},
            {0, 0, 1, 0, 0, 0},
            {1, 1, 0, 1, 1, 0},
            {0, 1, 0, 0, 0, 0}
        };

        System.out.println(a.solution(game_board, table));
    }

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;


        return answer;
    }


}
