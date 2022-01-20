package BJ;
//bfs
//벽 부수고 이동하기3

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair3 {

    int x,y,z, night;

    Pair3(int x, int y, int z, int night) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.night = night;
    }
}

public class No16933 {
    //TODO: 시간초과 해결하기
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][m];
        int[][][][] dist = new int[n][m][l + 1][2];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        dist[0][0][0][0] = 1;
        Queue<Pair3> q = new LinkedList<>();
        q.offer(new Pair3(0, 0, 0, 0));
        while (!q.isEmpty()) {
            Pair3 p = q.remove();
            int x = p.x;
            int y = p.y;
            int z = p.z;
            int night = p.night;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx <0 || nx >=n || ny < 0 || ny >= m) continue;
                if (a[nx][ny] == 0 && dist[nx][ny][z][1 - night] == 0) {
                    dist[nx][ny][z][1 - night] = dist[x][y][z][night] + 1;
                    q.offer(new Pair3(nx, ny, z, 1 - night));
                }
                if (night == 0 && z + 1 <= l && a[nx][ny] == 1
                    && dist[nx][ny][z + 1][1 - night] == 0) {
                    dist[nx][ny][z + 1][1 - night] = dist[x][y][z][night] + 1;
                    q.offer(new Pair3(nx, ny, z + 1, 1 - night));
                }
            }
            if (dist[x][y][z][1 - night] == 0) {
                dist[x][y][z][1 - night] = dist[x][y][z][night] + 1;
                q.offer(new Pair3(x, y, z, 1 - night));
            }
        }
        int ans = -1;
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i <= l; i++) {
                if (dist[n-1][m-1][i][j] == 0) continue;
                if (ans == -1) {
                    ans = dist[n - 1][m - 1][i][j];
                } else if (ans > dist[n - 1][m - 1][i][j]) {
                    ans = dist[n - 1][m - 1][i][j];
                }
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
