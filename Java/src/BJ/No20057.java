package BJ;
// 마법사 상어와 토네이도

import java.util.Scanner;

public class No20057 {

    static int N;
    static int[][] grid;
    static int[] dx = {0, 1, 0, -1}; // 왼쪽, 아래, 오른쪽, 위
    static int[] dy = {-1, 0, 1, 0};
    static int[][] sandRatio = {
            {0, 0, 2, 0, 0},
            {0, 10, 7, 1, 0},
            {5, 0, 0, 0, 0},
            {0, 10, 7, 1, 0},
            {0, 0, 2, 0, 0}
    };
    static int outSand = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int x = N / 2;
        int y = N / 2;
        int dir = 0;
        int moveLength = 1;

        while (true) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < moveLength; j++) {
                    x += dx[dir];
                    y += dy[dir];
                    if (x == 0 && y == -1) {
                        System.out.println(outSand);
                        return;
                    }
                    moveSand(x, y, dir);
                }
                dir = (dir + 1) % 4;
            }
            moveLength++;
        }
    }

    static void moveSand(int x, int y, int dir) {
        int sand = grid[x][y];
        int leftSand = sand;
        grid[x][y] = 0;

        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                int ratio = getRatio(i, j, dir);
                if (ratio == 0) continue;

                int nx = x + i;
                int ny = y + j;
                int moveSand = (sand * ratio) / 100;
                leftSand -= moveSand;

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    outSand += moveSand;
                } else {
                    grid[nx][ny] += moveSand;
                }
            }
        }

        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
            outSand += leftSand;
        } else {
            grid[nx][ny] += leftSand;
        }
    }

    static int getRatio(int i, int j, int dir) {
        if (dir == 0) return sandRatio[i + 2][j + 2];
        if (dir == 1) return sandRatio[j + 2][-(i - 2)];
        if (dir == 2) return sandRatio[(-i - 2)][-(j - 2)];
        return sandRatio[-(j - 2)][i + 2];
    }
}
