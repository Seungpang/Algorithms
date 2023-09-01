package BJ;
// 배열 놀이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17123 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][N];
            int[] rows = new int[N];
            int[] cols = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    arr[i][j] += value;
                    rows[i] += value;
                    cols[j] += value;
                }
            }

            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int r1 = Integer.parseInt(st.nextToken()) - 1;
                int c1 = Integer.parseInt(st.nextToken()) - 1;
                int r2 = Integer.parseInt(st.nextToken()) - 1;
                int c2 = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken());

                for (int r = r1; r <= r2; r++) {
                    rows[r] += (c2 - c1 + 1) * v;
                }

                for (int c = c1; c <= c2; c++) {
                    cols[c] += (r2 - r1 + 1) * v;
                }
            }

            for (int i = 0; i < N; i++) sb.append(rows[i] + " ");
            sb.append('\n');
            for (int i = 0; i < N; i++) sb.append(cols[i] + " ");
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
