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
            //현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            if (a[x + 1][y] != 0 && a[x - 1][y] != 0 && a[x][y + 1] != 0 && a[x][y - 1] != 0) {
                // 2-2 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                if (a[x - dx[dir]][y - dy[dir]] == 1) {
                    break;
                } else {
                    //2-1 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                    x -= dx[dir];
                    y -= dy[dir];
                }
            } else { // 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
                // 3-1 반시계 방향으로 90도 회전한다.
                dir = (dir + 3) % 4;
                // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
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
