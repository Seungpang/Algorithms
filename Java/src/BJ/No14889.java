package BJ;
// 스타트와 링크

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14889 {

    static int[][] ability;
    static boolean[] team;
    static int min = Integer.MAX_VALUE;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ability = new int[N][N];
        team = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        diviedTeam(0, 0);

        System.out.println(min);
    }

    private static void diviedTeam(int idx, int count) {
        if (count == N / 2) {
            diff();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!team[i]) {
                team[i] = true;
                diviedTeam(i + 1, count + 1);
                team[i] = false;
            }
        }
    }

    private static void diff() {
        int start = 0, link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (team[i] && team[j]) {
                    start += ability[i][j];
                    start += ability[j][i];
                } else if (!team[i] && !team[j]) {
                    link += ability[i][j];
                    link += ability[j][i];
                }
            }
        }

        min = Math.min(min, Math.abs(start - link));
    }
}
