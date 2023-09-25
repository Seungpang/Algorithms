package BJ;
// 뒤집기 II

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1455 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int result = 0;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                if (map[i][j] == 1) {
                    result++;
                    flip(map, i, j);
                }
            }
        }
        System.out.println(result);
    }

    static void flip(int[][] map, int x, int y) {
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                map[i][j] ^= 1;
            }
        }
    }
}
