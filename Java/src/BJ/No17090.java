package BJ;
// 미로 탈출하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17090 {

    static int[][] dirs = {
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };
    static int ans;
    static int N, M;
    static char[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                dp[i][j] = -1;
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dfs(i, j) == 1) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static int dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= M) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;
        int d = getDirection(map[x][y]);
        int[] dir = dirs[d];
        int nx = x + dir[0];
        int ny = y + dir[1];

        return dp[x][y] = dfs(nx, ny);
    }

    static int getDirection(char c) {
        switch (c) {
            case 'U':
                return 0;
            case 'R':
                return 1;
            case 'D':
                return 2;
            case 'L':
                return 3;
            default:
                return -1;
        }
    }
}
