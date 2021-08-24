package BJ;
//그래프
//단지번호붙이기

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class No2667 {

    static int[][] check;
    static int[][] a;
    static int n;
    public static final int[] dx = {0, 0, -1, 1};
    public static final int[] dy = {1, -1, 0, 0};

    public static void bfs(int i, int j, int cnt) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        check[i][j] = cnt;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            i = p.x;
            j = p.y;
            for (int k=0; k<4; k++) {
                int nx = i + dx[k];
                int ny = j + dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (a[nx][ny] == 1 && check[nx][ny] == 0) {
                        q.add(new Pair(nx, ny));
                        check[nx][ny] = cnt;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        a = new int[n][n];
        check = new int[n][n];
        for (int i=0; i<n; i++) {
            String s = sc.nextLine();
            for (int j=0; j<n; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        int cnt = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (a[i][j] == 1 && check[i][j] ==0) {
                    bfs(i, j, ++cnt);
                }
            }
        }

        int[] result = new int[cnt];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (check[i][j] != 0) {
                    result[check[i][j] - 1] += 1;
                }
            }
        }
        Arrays.sort(result);
        System.out.println(cnt);
        for (int i=0; i<cnt; i++) {
            System.out.println(result[i]);
        }
    }
}
