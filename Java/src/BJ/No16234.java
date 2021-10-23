package BJ;
//시뮬레이션 구현
//인구 이동

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No16234 {

    final static int[] dx = {0, 0, -1, 1};
    final static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();

        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        while (true) {
            if (bfs(a, l, r)) {
                ans += 1;
            } else {
                break;
            }
        }
        System.out.println(ans);
    }

    static boolean bfs(int[][] a, int l, int r) {
        int n = a.length;
        boolean[][] check = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                check[i][j] = false;
            }
        }

        boolean ok = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j]) {
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i);
                    q.add(j);
                    check[i][j] = true;
                    Queue<Integer> s = new LinkedList<>();
                    s.add(i);
                    s.add(j);
                    int sum = a[i][j];
                    while (!q.isEmpty()) {
                        int x = q.remove();
                        int y = q.remove();
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                                if (check[nx][ny]) continue;
                                int diff = a[nx][ny] - a[x][y];
                                if (diff < 0) diff = -diff;
                                if (l <= diff && diff <= r) {
                                    q.add(nx); q.add(ny);
                                    s.add(nx); s.add(ny);
                                    check[nx][ny] = true;
                                    ok = true;
                                    sum += a[nx][ny];
                                }
                            }
                        }
                    }
                    int val = sum / (s.size() / 2);
                    while (!s.isEmpty()) {
                        int x = s.remove();
                        int y = s.remove();
                        a[x][y] = val;
                    }
                }
            }
        }
        return ok;
    }
}
