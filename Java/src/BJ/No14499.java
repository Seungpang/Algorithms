package BJ;
//시뮬레이션과 구현
//주사위 굴리기

import java.util.Scanner;

public class No14499 {
    //동서북남
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int t = sc.nextInt();
        int[][] a = new int[n][m];
        int[] dice = new int[7];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        while (t-- >0) {
            int k = sc.nextInt() - 1;
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }
            //right
            if (k==0) {
                int temp = dice[1];
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = temp;
            } else if (k==1) {
                int temp = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = temp;
            } else if (k==2) {
                int temp = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = temp;
            } else if (k==3) {
                int temp = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = temp;
            }
            x = nx;
            y = ny;
            if (a[x][y] == 0) {
                a[x][y] = dice[6];
            } else {
                dice[6] = a[x][y];
                a[x][y] = 0;
            }
            System.out.println(dice[1]);
        }
    }
}
