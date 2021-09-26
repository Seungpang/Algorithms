package BJ;
//bfs
//움직이는 미로 탈출

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No16954 {

    static int[] dx = {0, 0, -1, 1, 1, 1, -1, -1, 0};
    static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 8;
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.next();
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[][][] check = new boolean[8][8][9];
        check[7][0][0] = true;
        q.add(7);
        q.add(0);
        q.add(0);
        boolean ans = false;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            int z = q.remove();
            if (x ==0 && y==7) ans = true;
            for (int k = 0; k < 9; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                int nz = Math.min(z + 1, 8);
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (nx-z>=0 && a[nx-z].charAt(ny) == '#') continue;
                    if (nx-z-1 >=0 && a[nx-z-1].charAt(ny) == '#') continue;
                    if (check[nx][ny][nz] == false) {
                        check[nx][ny][nz] = true;
                        q.add(nx);
                        q.add(ny);
                        q.add(nz);
                    }
                }
            }
        }
        System.out.println(ans ? 1 : 0);
    }
}
