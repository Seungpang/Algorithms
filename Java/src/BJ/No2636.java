package BJ;
// 치즈

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No2636 {
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] map;
    static int n, m;
    static int cheese;
    static boolean[][] visited;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    cheese++;
                }
            }
        }

        int count = 0;
        int time = 0;
        while (cheese != 0) {
            count = cheese;
            time++;
            visited = new boolean[n][m];
            bfs();
        }
        System.out.println(time);
        System.out.println(count);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int[] dir : dirs) {
                int nx = now[0] + dir[0];
                int ny = now[1] + dir[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (map[nx][ny] == 0) {
                        q.offer(new int[]{nx, ny});
                    } else {
                        cheese--;
                        map[nx][ny] = 0;
                    }
                }
            }
        }
    }
}
