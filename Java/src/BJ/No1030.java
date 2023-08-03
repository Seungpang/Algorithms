package BJ;
// 프렉탈 평면

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1030 {

    static int s, N, K, R1, R2, C1, C2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R1 = Integer.parseInt(st.nextToken());
        R2 = Integer.parseInt(st.nextToken());
        C1 = Integer.parseInt(st.nextToken());
        C2 = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        int size = (int) Math.pow(N, s);
        for (int r = R1; r <= R2; r++) {
            for (int c = C1; c <= C2; c++) {
                sb.append(isBlack(r, c, size) ? 1 : 0);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static boolean isBlack(int x, int y, int size) {
        if (size == 1) {
            return false;
        }

        int newSize = size / N;
        int midSize = (N - K) / 2;

        if (x/newSize >= midSize && x / newSize < midSize + K && y / newSize >= midSize && y / newSize < midSize + K) {
            return true;
        }
        return isBlack(x % newSize, y % newSize, newSize);
    }
}
