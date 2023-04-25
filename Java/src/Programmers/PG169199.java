package Programmers;
//리코쳇 로봇

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PG169199 {

    public static void main(String[] args) {
        final PG169199 pg169199 = new PG169199();
        System.out.println(pg169199.solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
    }

    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0, 1}};
    int startX, startY, endX, endY, n, m;
    boolean[][] visited;
    int[][] arr;

    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        visited = new boolean[n][m];
        arr = new int[n][m];
        for (int i=0; i<n; i++) {
            Arrays.fill(arr[i], 100000);
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i].charAt(j) == 'R') {
                    startX = i;
                    startY = j;
                } else if (board[i].charAt(j) == 'G') {
                    endX = i;
                    endY = j;
                }
            }
        }
        bfs(startX, startY, board);
        return arr[endX][endY];
    }

    public void bfs(int i, int j, String[] board) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        arr[i][j] = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int[] dir : dirs) {
                int dx = now[0] + dir[0];
                int dy = now[1] + dir[1];
                while (dx >= 0 && dy >= 0 && dx < n && dy < m && board[dx].charAt(dy) != 'D') {
                    dx += dir[0];
                    dy += dir[1];
                }
                dx -= dir[0];
                dy -= dir[1];
                if (visited[dx][dy]) {
                    continue;
                }
                q.offer(new int[]{dx, dy});
                visited[dx][dy] = true;
                arr[dx][dy] = Math.min(arr[dx][dy], arr[now[0]][now[1]] + 1);
            }
        }
    }
}
