package BJ;
// 마법사 상어와 비바라기

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No21610 {

    static int[][] dirs = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        Queue<int[]> clouds = new LinkedList<>();
        clouds.add(new int[]{n - 1, 0});
        clouds.add(new int[]{n - 1, 1});
        clouds.add(new int[]{n - 2, 0});
        clouds.add(new int[]{n - 2, 1});
        while (m-- > 0) {
            int d = sc.nextInt() - 1;
            int s = sc.nextInt();
            for (int[] cloud : clouds) {
                cloud[0] = (n + cloud[0] + dirs[d][0] * (s % n)) % n;
                cloud[1] = (n + cloud[1] + dirs[d][1] * (s % n)) % n;
                map[cloud[0]][cloud[1]]++;
            }

            while (!clouds.isEmpty()) {
                int[] now = clouds.poll();
                int count = 0;

                visited[now[0]][now[1]] = true;
                for (int i = 1; i <= 7; i += 2) {
                    int nx = now[0] + dirs[i][0];
                    int ny = now[1] + dirs[i][1];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && (map[nx][ny] >= 1)) {
                        count++;
                    }
                }
                map[now[0]][now[1]] += count;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && map[i][j] >= 2) {
                        map[i][j] -= 2;
                        clouds.add(new int[]{i, j});
                    }
                }
            }
            visited = new boolean[n][n];
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += map[i][j];
            }
        }

        System.out.println(result);
    }
}
