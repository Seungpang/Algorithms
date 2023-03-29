package BJ;
// 스티커 붙이기

import java.util.Scanner;

public class No18808 {
    static int[][] map = new int[11][11];
    static int[][] notebook = new int[41][41];
    static int n,m,r, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int k = sc.nextInt();
        while (k-- > 0) {
            r = sc.nextInt();
            c = sc.nextInt();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int rot = 0; rot < 4; rot++) {
                boolean isPaste = false;
                for (int x = 0; x <= n - r; x++) {
                    if (isPaste) {
                        break;
                    }
                    for (int y = 0; y <= m - c; y++) {
                        if(pastable(x, y)) {
                            isPaste = true;
                            break;
                        }
                    }
                }
                if (isPaste) {
                    break;
                }
                rotate();
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count += notebook[i][j];
            }
        }
        System.out.println(count);
    }

    public static boolean pastable(int x, int y) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (notebook[x + i][y + j] == 1 && map[i][j] == 1) {
                    return false;
                }
            }
        }
        for (int i=0; i<r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 1) {
                    notebook[x + i][y + j] = 1;
                }
            }
        }
        return true;
    }

    public static void rotate() {
        int[][] temp = new int[11][11];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                temp[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                map[i][j] = temp[r - 1 - j][i];
            }
        }
        int tmp = r;
        r = c;
        c = tmp;
    }
}
