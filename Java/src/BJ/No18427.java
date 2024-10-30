package BJ;
// 함께 블록 쌓기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No18427 {

    static final int MOD = 10007;
    static int N, M, H;
    static ArrayList<Integer>[] blocks;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        blocks = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            blocks[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                blocks[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        dp = new int[N][H + 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(solve(0, 0));
    }

    static int solve(int student, int height) {
        if (height == H) return 1;
        if (height > H || student == N) return 0;
        if (dp[student][height] != -1) return dp[student][height];

        int result = solve(student + 1, height) % MOD;

        for (int block : blocks[student]) {
            result = (result + solve(student + 1, height + block)) % MOD;
        }

        return dp[student][height] = result;
    }
}
