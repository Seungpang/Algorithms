package BJ;
//bfs
//벽 부수고 이동하기

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x,y, z;
    Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class No2206 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] a = new int[n][m];
        for (int i=0; i<n; i++) {
            String s = sc.nextLine();
            for (int j=0; j<m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        int[][][] dist = new int[n][m][2];
        dist[0][0][0] = 1;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0));
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        while (!q.isEmpty()) {
            Point p = q.remove();
            int x = p.x;
            int y = p.y;
            int z = p.z;
            for (int k=0; k<4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (a[nx][ny] == 0 && dist[nx][ny][z] == 0) {
                        dist[nx][ny][z] = dist[x][y][z] + 1;
                        q.add(new Point(nx, ny, z));
                    }
                    if (z == 0 && a[nx][ny] == 1 && dist[nx][ny][z] == 0) {
                        dist[nx][ny][z + 1] = dist[x][y][z] + 1;
                        q.add(new Point(nx, ny, z+1));
                    }
                }
            }
        }
        if (dist[n - 1][m - 1][0] != 0 && dist[n - 1][m - 1][1] != 0) {
            System.out.println(Math.min(dist[n - 1][m - 1][0], dist[n - 1][m - 1][1]));
        } else if (dist[n-1][m-1][0] != 0) {
            System.out.println(dist[n - 1][m - 1][0]);
        } else if (dist[n-1][m-1][1] != 0 ) {
            System.out.println(dist[n - 1][m - 1][1]);
        } else {
            System.out.println(-1);
        }
    }
}
