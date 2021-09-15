package BJ;
//bfs
//벽 부수고 이동하기2

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No14442 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();
        int[][] a = new int[n][m];
        int[][][] dist = new int[n][m][l+1];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        dist[0][0][0] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(0);
        q.add(0);
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            int z = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (dist[nx][ny][z] == 0 && a[nx][ny]==0) {
                        dist[nx][ny][z] = dist[x][y][z] + 1;
                        q.add(nx);
                        q.add(ny);
                        q.add(z);
                    }
                    if (z+1 <= l && dist[nx][ny][z+1] == 0 && a[nx][ny] == 1) {
                        dist[nx][ny][z + 1] = dist[x][y][z] + 1;
                        q.add(nx);
                        q.add(ny);
                        q.add(z + 1);
                    }
                }
            }
        }
        int ans = -1;
        for (int i = 0; i <= l; i++) {
            if (dist[n-1][m-1][i] == 0) continue;
            if (ans == -1) {
                ans = dist[n - 1][m - 1][i];
            } else if (ans > dist[n - 1][m - 1][i]) {
                ans = dist[n - 1][m - 1][i];
            }
        }
        System.out.println(ans);
    }
}
