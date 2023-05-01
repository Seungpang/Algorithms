package BJ;
// 공주님을 구해라!

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No17836 {

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        boolean[][][] visited = new boolean[n][m][2];

        Queue<Warrior> q = new LinkedList<>();
        q.offer(new Warrior(0, 0, 0, false));
        visited[0][0][0] = true;
        while (!q.isEmpty()) {
            Warrior now = q.poll();
            if (now.time > t) break;
            if (now.x == n - 1 && now.y == m - 1) {
                System.out.println(now.time);
                return;
            }
            for (int[] dir : dirs) {
                int dx = now.x + dir[0];
                int dy = now.y + dir[1];
                if (dx >= 0 && dy >= 0 && dx < n && dy < m) {
                    if (!now.isGeulam) {
                        if (!visited[dx][dy][0] && map[dx][dy] == 0) {
                            visited[dx][dy][0] = true;
                            q.offer(new Warrior(dx, dy, now.time + 1, now.isGeulam));
                        } else if (!visited[dx][dy][0] && map[dx][dy] == 2) {
                            visited[dx][dy][0] = true;
                            q.offer(new Warrior(dx, dy, now.time + 1, true));
                        }
                    } else {
                        if (!visited[dx][dy][1]) {
                            q.offer(new Warrior(dx, dy, now.time + 1, now.isGeulam));
                            visited[dx][dy][1] = true;
                        }
                    }
                }
            }
        }
        System.out.println("Fail");
    }

    static class Warrior {
        int x,y,time;
        boolean isGeulam;

        public Warrior(int x, int y, int time, boolean isGeulam) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.isGeulam = isGeulam;
        }
    }
}
