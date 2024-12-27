package BJ;
// 섬의 개수

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No4963 {

    static int w, h;
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while ((w = sc.nextInt()) != 0) {
            h = sc.nextInt();
            int[][] map = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int count = 0;
            for (int row = 0; row < h; row++) {
                for (int col = 0; col < w; col++) {
                    if (map[row][col] == 1) {
                        count++;
                        bfs(map, row, col);
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void bfs(int[][] map, int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];
                if (nx >= 0 && nx < h && ny >= 0 && ny < w  && map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
