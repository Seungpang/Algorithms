package BJ;
//시뮬레이션 구현
//로봇 청소기

import java.util.Scanner;

public class No14503 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int dir = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int cnt = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (true) {
            //1. 현재 위치를 청소
            if (a[x][y] == 0) {
                a[x][y] = 2;
            }
            if (a[x + 1][y] != 0 && a[x - 1][y] != 0 && a[x][y + 1] != 0 && a[x][y - 1] != 0) {
                //2-d
                if (a[x - dx[dir]][y - dy[dir]] == 1) {
                    break;
                } else {
                    //2-c
                    x -= dx[dir];
                    y -= dy[dir];
                }
            } else {
                //2-b
                dir = (dir + 3) % 4;
                if (a[x + dx[dir]][y + dy[dir]] == 0) {
                    x += dx[dir];
                    y += dy[dir];
                }
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j]==2) {
                    cnt += 1;
                }
            }
        }
        System.out.println(cnt);
    }
}
