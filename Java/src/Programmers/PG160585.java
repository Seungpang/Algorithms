package Programmers;
// 혼자서 하는 틱택토
public class PG160585 {

    public static void main(String[] args) {
        final PG160585 pg160585 = new PG160585();
        System.out.println(pg160585.solution(new String[]{"O.X", ".O.", "..X"}));
        String s = "abcd";
        System.out.println(s.substring(2));
    }

    public int solution(String[] board) {
        int zeroCount = 0;
        int xCount = 0;
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length(); j++) {
                if (board[i].charAt(j) == 'O') {
                    zeroCount++;
                } else if (board[i].charAt(j) == 'X') {
                    xCount++;
                }
            }
        }

        if (zeroCount - xCount < 0 || zeroCount - xCount > 1) {
            return 0;
        }

        boolean zeroWin = checkLine(board, 'O');
        boolean xWin = checkLine(board, 'X');

        if (zeroWin && xWin) {
            return 0;
        }
        if (xWin && zeroCount > xCount || zeroWin && xCount >= zeroCount) {
            return 0;
        }
        return 1;
    }

    public boolean checkLine(String[] board, char c) {
        //가로
        for (int i=0; i<3; i++) {
            if (board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c) {
                return true;
            }
        }
        //세로
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c) {
                return true;
            }
        }
        //대각선
        if (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) {
            return true;
        }
        return board[2].charAt(0) == c && board[1].charAt(1) == c && board[0].charAt(2) == c;
    }
}
