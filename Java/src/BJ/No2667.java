package BJ;
//그래프
//단지번호붙이기

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//class Pair {
//    int x, y;
//    Pair(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}

public class No2667 {

    static int n;
    static int[][] a;
    static int[][] visited;
    static int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n][n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < n; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        visited = new int[n][n];
        int cnt = 0;
        for (int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1 && visited[i][j] == 0) {
                    bfs(i, j, ++cnt);
                }
            }
        }

        int[] result = new int[cnt];
        for (int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] != 0) {
                    result[visited[i][j] - 1] += 1;
                }
            }
        }
        Arrays.sort(result);
        System.out.println(cnt);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static void dfs(int i, int j, int cnt) {
        visited[i][j] = cnt;
        for (int[] dir : dirs) {
            int nx = i + dir[0];
            int ny = j + dir[1];
            if (nx < n && nx >= 0 && ny < n && ny >= 0) {
                if (a[nx][ny] == 1 && visited[nx][ny] == 0) {
                    visited[nx][ny] = cnt;
                    bfs(nx, ny, cnt);
                }
            }
        }
    }

    public static void bfs(int i, int j, int cnt) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        visited[i][j] = cnt;

        while (!q.isEmpty()) {
            Pair now = q.poll();
            for (int[] dir : dirs) {
                i = now.x + dir[0];
                j = now.y + dir[1];
                if (i < n && i >= 0 && j < n && j >= 0) {
                    if (a[i][j] == 1 && visited[i][j] == 0) {
                        visited[i][j] = cnt;
                        q.add(new Pair(i, j));
                    }
                }
            }
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }
}
