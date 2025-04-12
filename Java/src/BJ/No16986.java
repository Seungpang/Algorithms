package BJ;
// 인싸들의 가위바위보

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16986 {

    static int N, K;
    static int[][] win;
    static int[] jiwoo = new int[20];
    static int[] kyunghee = new int[20];
    static int[] minho = new int[20];
    static boolean[] used;
    static boolean foundWin = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        win = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                win[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 20; i++) {
            kyunghee[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 20; i++) {
            minho[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        used = new boolean[N];

        dfs(0);
        System.out.println(foundWin ? 1 : 0 );
    }

    static void dfs(int depth) {
        if (foundWin) return;

        if (depth == N) {
            ssimulate();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                used[i] = true;
                jiwoo[depth] = i;
                dfs(depth + 1);
                used[i] = false;
            }
        }
    }

    static void ssimulate() {
        int[] winCount = new int[3];
        int[] idx = new int[3];
        int p1 = 0, p2 = 1;

        while (true) {
            if (winCount[0] >= K) {
                foundWin = true;
                return;
            }

            if (winCount[1] >= K || winCount[2] >= K) return;

            int m1 = getMove(p1, idx[p1]);
            int m2 = getMove(p2, idx[p2]);
            if (m1 == -1 || m2 == -1) return;

            idx[p1]++;
            idx[p2]++;

            int winner;
            if (win[m1][m2] == 2) {
                winner = p1;
            } else if (win[m1][m2] == 0) {
                winner = p2;
            } else {
                winner = Math.max(p1, p2);
            }

            winCount[winner]++;

            int waiting = 3 - p1 - p2;
            p1 = winner;
            p2 = waiting;
        }
    }

    static int getMove(int player, int idx) {
        if (player == 0) {
            return (idx >= N) ? -1 : jiwoo[idx];
        } else if (player == 1) {
            return (idx >= 20) ? -1 : kyunghee[idx];
        } else {
            return (idx >= 20) ? -1 : minho[idx];
        }
    }
}
