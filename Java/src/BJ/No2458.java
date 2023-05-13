package BJ;
// 키 순서

import java.util.Scanner;

public class No2458 {
    static int n, m;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n+1][n+1];
        for (int i = 1; i <= m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            visited[s][e] = true;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (visited[i][k] && visited[k][j]) {
                        visited[i][j] = true;
                    }
                }
            }
        }

        int[] count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (visited[i][j] || visited[j][i]) {
                    count[i]++;
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (count[i] == n - 1) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
