package BJ;
// 양 한마리... 양 두마리...

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No11123 {

    static int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    static int row, col;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            map = new char[row][col];
            for (int i = 0; i < row; i++) {
                String str = br.readLine();
                for (int j = 0; j < col; j++) {
                    map[i][j] = str.charAt(j);
                }
            }

            int count = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (map[i][j] == '#') {
                        count++;
                        bfs(i, j);
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void bfs(int x, int y) {
        map[x][y] = '.';
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int[] dir : dirs) {
                int nx = now[0] + dir[0];
                int ny = now[1] + dir[1];
                if (nx >= 0 && nx < row && ny >= 0 && ny < col && map[nx][ny] == '#') {
                    map[nx][ny] = '.';
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
