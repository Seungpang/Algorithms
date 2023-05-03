package BJ;
// 소문난 칠공주

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No1941 {

    static int ans;
    static char[][] map;
    static boolean[] visited;
    static int[] checked = new int[7];
    static int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new char[5][5];
        for (int i = 0; i < 5; i++) {
            map[i] = sc.next().toCharArray();
        }

        comb(0, 0, 0);
        System.out.println(ans);
    }

    static void comb(int count, int start, int sCnt) {
        if (count - sCnt > 3) {
            return;
        }

        if (count == 7) {
            visited = new boolean[7];
            bfs(checked[0] / 5, checked[0] % 5);
            return;
        }

        for (int i = start; i < 25; i++) {
            int row = i / 5;
            int col = i % 5;
            checked[count] = i;
            comb(count + 1, i + 1, map[row][col] == 'S' ? sCnt + 1 : sCnt);
        }
    }

    static void bfs(int x, int y) {
        int num = 1;
        visited[0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int[] dir : dirs) {
                int dx = now[0] + dir[0];
                int dy = now[1] + dir[1];
                if (dx < 0 || dy < 0 || dx >= 5 || dy >= 5) {
                    continue;
                }
                int next = 5 * dx + dy;
                for (int i = 0; i < 7; i++) {
                    if (!visited[i] && checked[i] == next) {
                        visited[i] = true;
                        num++;
                        q.offer(new int[]{dx, dy});
                    }
                }
            }
        }
        if (num == 7) ans++;
    }
}
