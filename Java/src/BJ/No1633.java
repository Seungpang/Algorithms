package BJ;
// 최고의 팀 만들기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No1633 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Player> players = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String[] parts = line.split(" ");
            int white = Integer.parseInt(parts[0]);
            int black = Integer.parseInt(parts[1]);
            players.add(new Player(white, black));
        }

        int N = players.size();
        int[][][] dp = new int[N + 1][16][16];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= 15; j++) {
                for (int k = 0; k <= 15; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        dp[0][0][0] = 0;

        for (int i = 1; i <= N; i++) {
            Player player = players.get(i - 1);
            for (int j = 0; j <= 15; j++) {
                for (int k = 0; k <= 15; k++) {
                    if (dp[i - 1][j][k] != Integer.MIN_VALUE) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k]);
                    }

                    if (j > 0 && dp[i - 1][j - 1][k] != Integer.MIN_VALUE) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - 1][k] + player.white);
                    }

                    if (k > 0 && dp[i - 1][j][k - 1] != Integer.MIN_VALUE) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k - 1] + player.black);
                    }
                }
            }
        }

        System.out.println(dp[N][15][15]);
    }

    static class Player {
        int white;
        int black;

        public Player(final int white, final int black) {
            this.white = white;
            this.black = black;
        }
    }
}
