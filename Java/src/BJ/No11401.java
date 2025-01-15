package BJ;
// 이항 계수 3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11401 {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] fact = new long[N+1];
        long[] invFact = new long[N+1];

        fact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i] = fact[i-1] * i % MOD;
        }

        invFact[N] = modPow(fact[N], MOD - 2);
        for (int i = N; i >= 1; i--) {
            invFact[i-1] = invFact[i] * i % MOD;
        }

        long answer = fact[N] * invFact[K] % MOD;
        answer = answer * invFact[N-K] % MOD;

        System.out.println(answer);
    }

    public static long modPow(long x, long y) {
        long result = 1;
        x %= MOD;
        while (y > 0) {
            if ((y & 1) == 1) result = (result * x) % MOD;
            x = (x * x) % MOD;
            y >>= 1;
        }
        return result;
    }
}
