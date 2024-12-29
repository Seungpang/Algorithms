package BJ;
// 전쟁 - 전투

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1303 {

    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited =new boolean[M][N];
        map = new char[M][N];

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int whiteValue = 0;
        int blackValue = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    if (map[i][j] == 'W') {
                        whiteValue += bfs(i, j, 'W');
                    } else {
                        blackValue += bfs(i, j, 'B');
                    }
                }
            }
        }

        System.out.println(whiteValue + " " + blackValue);
    }

    static int bfs(int i, int j, char color) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;

        int count = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == color) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    count++;
                }
            }
        }

        return count * count;
    }
}
