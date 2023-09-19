package BJ;
// 효구와 호규 (Eazy)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No26085 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int countZero = 0;
        int countOne = 0;
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    countOne++;
                } else {
                    countZero++;
                }
            }
        }
        if (countZero % 2 == 0 && countOne % 2 == 0 && isMove(map)) {
            System.out.println(1);
        } else {
            System.out.println(-1);
        }
    }

    private static boolean isMove(int[][] map) {
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M-1; j++) {
                if (map[i][j] == map[i][j + 1] || map[i][j] == map[i + 1][j] || map[i + 1][j + 1] == map[i + 1][j] || map[i + 1][j + 1] == map[i][j + 1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
