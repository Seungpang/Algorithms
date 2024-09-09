package BJ;
// 월드컵

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No6879 {
    static int[][] results = new int[6][3];
    static int[][] games = {{0,1},{0,2},{0,3},{0,4},{0,5},{1,2},{1,3},{1,4},{1,5},{2,3},{2,4},{2,5},{3,4},{3,5},{4,5}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < 4; t++) {
            boolean valid = true;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 6; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    results[i][j] = Integer.parseInt(st.nextToken());
                    sum += results[i][j];
                }
                if (sum != 5) {
                    valid = false;
                    break;
                }
            }
            if (!valid) {
                sb.append("0 ");
            } else {
                sb.append(backtrack(0) ? "1 " : "0 ");
            }
        }

        System.out.println(sb);
    }

    static boolean backtrack(int gameIndex) {
        if (gameIndex == 15) return true;

        int team1 = games[gameIndex][0];
        int team2 = games[gameIndex][1];

        for (int result = 0; result < 3; result++) {
            if (result == 0 && results[team1][0] > 0 && results[team2][2] > 0) {
                results[team1][0]--;
                results[team2][2]--;
                if (backtrack(gameIndex + 1)) return true;
                results[team1][0]++;
                results[team2][2]++;
            } else if (result == 1 && results[team1][1] > 0 && results[team2][1] > 0) {
                results[team1][1]--;
                results[team2][1]--;
                if (backtrack(gameIndex + 1)) return true;
                results[team1][1]++;
                results[team2][1]++;
            } else if (result == 2 && results[team1][2] > 0 && results[team2][0] > 0) {
                results[team1][2]--;
                results[team2][0]--;
                if (backtrack(gameIndex + 1)) return true;
                results[team1][2]++;
                results[team2][0]++;
            }
        }

        return false;
    }
}
