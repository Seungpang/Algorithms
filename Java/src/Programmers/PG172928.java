package Programmers;
// 공원 산책
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PG172928 {

    public static void main(String[] args) {
        final PG172928 pg172928 = new PG172928();
        System.out.println(
                Arrays.toString(
                        pg172928.solution(new String[]{"OSO","OOO","OXO","OOO"}, new String[]{"E 2","S 3","W 1"})));
    }

    public int[] solution(String[] park, String[] routes) {
        Map<String, Point> map = new HashMap<>();
        map.put("E", new Point(0, 1));
        map.put("S", new Point(1, 0));
        map.put("W", new Point(0, -1));
        map.put("N", new Point(-1, 0));
        char[][] board = new char[park.length][park[0].length()];
        int startX = 0;
        int startY = 0;
        for (int i=0; i<park.length; i++) {
            for (int j=0; j<park[0].length(); j++) {
                board[i][j] = park[i].charAt(j);
                if (board[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
            }
        }

        for (String route : routes) {
            String[] command = route.split(" ");
            Point point = map.get(command[0]);
            int nx = startX;
            int ny = startY;
            for (int i = 0; i < Integer.parseInt(command[1]); i++) {
                nx = nx + point.x;
                ny = ny + point.y;
                if (nx < 0 || nx >= park.length || ny < 0 || ny >= park[0].length() || board[nx][ny] == 'X') {
                    nx = startX;
                    ny = startY;
                    break;
                }
            }
            startX = nx;
            startY = ny;
        }
        return new int[] {startX, startY};
    }
    static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
