package BJ;
// 한윤정이 이탈리아에 가서 아이스크림을 사먹는데

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2422 {

    static int N, M, result;
    static boolean[][] incompatible;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        incompatible = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            incompatible[a][b] = true;
            incompatible[b][a] = true;
        }

        result = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (incompatible[i][j]) continue;
                for (int k = j + 1; k <= N; k++) {
                    if (!incompatible[i][k] && !incompatible[j][k]) {
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
