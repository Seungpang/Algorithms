package BJ;
// 징검다리 건너기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No21317 {

    static int N, K;
    static int[][] stones;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        stones = new int[N][2];
        for (int i = 1; i <= N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            stones[i][0] = Integer.parseInt(st.nextToken());
            stones[i][1] = Integer.parseInt(st.nextToken());
        }

        K = Integer.parseInt(br.readLine());

        dfs(0, 1, false);

        System.out.println(answer);
    }

    private static void dfs(int sum, int index, boolean flag) {
        if (index == N) {
            answer = Math.min(sum, answer);
            return;
        }

        if (index > N) {
            return;
        }

        dfs(sum + stones[index][0], index + 1, flag);
        dfs(sum + stones[index][1], index + 2, flag);

        if (!flag) {
            dfs(sum + K, index + 3, true);
        }
    }
}
