package BJ;
//안내의 도미노 장인 호석

import java.util.Scanner;

public class No20165 {

    static int n,m,r, ans;
    static int[][] a, backup;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        a = new int[n+1][m+1];
        backup = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = sc.nextInt();
                backup[i][j] = a[i][j];
            }
        }

        while (r-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String dir = sc.next();

            // 공격
            attack(x, y, dir.charAt(0));

            // 수비
            x = sc.nextInt();
            y = sc.nextInt();
            a[x][y] = backup[x][y];
        }
        System.out.println(ans);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i][j] == 0) {
                    System.out.print("F ");
                } else {
                    System.out.print("S ");
                }
            }
            System.out.println();
        }
    }

    static void attack(int x, int y, char dir) {
        if (a[x][y] == 0) {
            return;
        }

        int dx = 0, dy = 0;
        if (dir == 'E') {
            dy = 1;
        } else if (dir == 'W') {
            dy = -1;
        } else if (dir == 'S') {
            dx = 1;
        } else {
            dx = -1;
        }

        int cnt = a[x][y];
        while (x >= 1 && x <= n && y >= 1 && y <= m && cnt >= 1) {
            if (a[x][y] != 0) {
                ans++;
            }

            cnt = Math.max(cnt - 1, a[x][y] - 1);

            a[x][y] = 0;

            x += dx;
            y += dy;
        }
    }
}
