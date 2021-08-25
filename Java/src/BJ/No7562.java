package BJ;
//그래프
//나이트의 이동

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//class Pair {
//    int x,y;
//    Pair(int x,int y) {
//        this.x = x;
//        this.y = y;
//    }
//}

public class No7562 {

    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- >0) {
            int n = sc.nextInt();
            int sx = sc.nextInt();
            int sy = sc.nextInt();
            int ex = sc.nextInt();
            int ey = sc.nextInt();
            int[][] d = new int[n][n];
            for (int i=0; i<n; i++) {
                Arrays.fill(d[i], -1);
            }
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(sx, sy));
            d[sx][sy] = 0;
            while (!q.isEmpty()) {
                Pair p = q.remove();
                int x = p.x;
                int y = p.y;
                for (int k=0; k<8; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                        if (d[nx][ny] == -1) {
                            d[nx][ny] = d[x][y] + 1;
                            q.add(new Pair(nx, ny));
                        }
                    }
                }
            }
            System.out.println(d[ex][ey]);
        }
    }
}
