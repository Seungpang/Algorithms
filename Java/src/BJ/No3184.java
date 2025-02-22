package BJ;
// 양

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No3184 {

    static char[][] map;
    static int R, C;
    static boolean[][] visited;
    static int totalWolf, totalSheep;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != '#' && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(totalSheep + " " + totalWolf);
    }

    static void bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        visited[row][col] = true;

        int sheep = 0;
        int wolf = 0;
        if (map[row][col] == 'o') {
            sheep++;
        } else if (map[row][col] == 'v') {
            wolf++;
        }

        boolean isEscape = false;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    isEscape = true;
                    continue;
                }

                if (visited[nx][ny] || map[nx][ny] == '#') continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});

                if (map[nx][ny] == 'o') sheep++;
                else if (map[nx][ny] == 'v') wolf++;
            }
        }

        if (isEscape) return;

        if (sheep > wolf) {
            totalSheep += sheep;
        } else {
            totalWolf += wolf;
        }
    }
}
