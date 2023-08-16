package BJ;
// 다리 놓기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1010 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            System.out.println(combine(M, N));
        }
    }

    private static long combine(int m, int n) {
        if (n == 0 || m == 0) {
            return 1;
        }

        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * (m - n + i) / i;
        }

        return result;
    }
}
