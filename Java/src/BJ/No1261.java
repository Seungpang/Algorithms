package BJ;
//bfs
//알고스팟

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

public class No1261 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        int[][] a = new int[n][m];
        int[][] dist = new int[n][m];
        for (int i=0; i<n; i++) {
            String s = sc.nextLine();
            for (int j=0; j<m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        Queue<Pair> q = new LinkedList<>();
        Queue<Pair> next_q = new LinkedList<>();
        q.add(new Pair(0, 0));
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                dist[i][j] = -1;
            }
        }
        dist[0][0] = 0;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k=0; k<4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (dist[nx][ny] == -1) {
                        if (a[nx][ny] == 0) {
                            dist[nx][ny] = dist[x][y];
                            q.add(new Pair(nx, ny));
                        }
                        if (a[nx][ny] == 1) {
                            dist[nx][ny] = dist[x][y] + 1;
                            next_q.add(new Pair(nx, ny));
                        }
                    }

                }
            }
            if (q.isEmpty()) {
                q = next_q;
                next_q = new LinkedList<>();
            }
        }
        System.out.println(dist[n-1][m-1]);
    }
}
