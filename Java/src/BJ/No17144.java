package BJ;
// 미세먼지 안녕

import java.util.Scanner;

public class No17144 {

    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int t = sc.nextInt();
        int[][] map = new int[r][c];
        int acTop = -1, acBot = -1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == -1) {
                    if (acTop < 0) {
                        acTop = i;
                    } else {
                        acBot = i;
                    }
                }
            }
        }
        while (t-- > 0) {
            // 미세먼지 확산
            int[][] temp = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (map[i][j] > 0) {
                        int count = 0;
                        int amount = map[i][j] / 5;
                        for (int[] dir : dirs) {
                            int dx = i + dir[0];
                            int dy = j + dir[1];
                            if (dx < 0 || dy < 0 || dx >= r || dy >= c || map[dx][dy] == -1) {
                                continue;
                            }
                            temp[dx][dy] += amount;
                            count++;
                        }
                        temp[i][j] += map[i][j] - amount * count;
                    }
                }
            }

            int[][] tmp = map;
            map = temp;
            temp = tmp;

            // 공기청정기 작동
            //시계 반대반향
            temp[acTop][1] = 0;
            for (int j = 2; j < c; j++) {
                temp[acTop][j] = map[acTop][j - 1];
            }

            for (int i = acTop-1; i >= 0; i--) {
                temp[i][c - 1] = map[i + 1][c - 1];
            }

            for (int j = c - 1; j > 0; j--) {
                temp[0][j - 1] = map[0][j];
            }

            for (int i = 1; i <= acTop - 1; i++) {
                temp[i][0] = map[i - 1][0];
            }

            //시계방향
            temp[acBot][1] = 0;
            for (int j = 2; j < c; j++) {
                temp[acBot][j] = map[acBot][j - 1];
            }

            for (int i = acBot+1; i < r; i++) {
                temp[i][c - 1] = map[i-1][c - 1];
            }

            for (int j = c - 1; j > 0; j--) {
                temp[r-1][j - 1] = map[r-1][j];
            }

            for (int i = r-2; i >= acBot+1; i--) {
                temp[i][0] = map[i+1][0];
            }
            for (int i = 0; i < r; i++) {
                System.arraycopy(temp[i], 0, map[i], 0, c);
            }
        }
        int result = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != -1) {
                    result += map[i][j];
                }
            }
        }
        System.out.println(result);
    }
}
