package Programmers;
//2019 카카오 개발자 겨울 인턴십
//크레인 인형뽑기 게임

import java.util.Stack;

public class PG64061 {

    public static void main(String[] args) {
        PG64061 a = new PG64061();
        int[][] board = {
            {0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}
        };
        int[] move = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(a.solution(board, move));
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][move - 1] != 0) {
                    if (stack.peek() == board[i][move - 1]) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[i][move - 1]);
                    }
                    board[i][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
