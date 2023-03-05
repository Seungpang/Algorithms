package BJ;
//그래프
//미로 탐색

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No2178 {

    static int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static int[][] arr;
    static boolean[][] visited;
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        visited = new boolean[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        bfs(0, 0);
        System.out.println(arr[n - 1][m - 1]);
    }

    private static void bfs(int i, int j) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        visited[i][j] = true;
        while (!q.isEmpty()) {
            final Pair now = q.poll();
            for (int[] dir : dirs) {
                int dx = now.x + dir[0];
                int dy = now.y + dir[1];
                if (dx >= 0 && dy >= 0 && dx < n && dy < m) {
                    if (arr[dx][dy] != 0 && !visited[dx][dy]) {
                        visited[dx][dy] = true;
                        arr[dx][dy] = arr[now.x][now.y] + 1;
                        q.add(new Pair(dx, dy));
                    }
                }
            }
        }
    }
}
