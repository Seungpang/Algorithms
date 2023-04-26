package BJ;
// 늑대와 양

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No16956 {

    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        sc.nextLine();
        char[][] map = new char[r][c];
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'W') {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int isPossible = 1;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int[] dir : dirs) {
                int dx = now[0] + dir[0];
                int dy = now[1] + dir[1];
                if (dx < 0 || dy < 0 || dx >= r || dy >= c || visited[dx][dy]) {
                    continue;
                }
                if (map[dx][dy] == 'S') {
                    isPossible = 0;
                    break;
                }
                map[dx][dy] = 'D';
                visited[dx][dy] = true;
            }
        }

        if (isPossible == 1) {
            System.out.println(1);
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println(0);
        }
    }
}
