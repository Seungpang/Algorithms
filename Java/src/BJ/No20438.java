package BJ;
// 출석체크

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No20438 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] sleep = new boolean[N + 3];
        boolean[] attend = new boolean[N + 3];
        int[] prefixSum = new int[N + 3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            sleep[Integer.parseInt(st.nextToken())] = true;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int start = Integer.parseInt(st.nextToken());
            if (sleep[start]) {
                continue;
            }
            for (int j = start; j < N+3; j+=start) {
                if (!sleep[j]) {
                    attend[j] = true;
                }
            }
        }

        for (int i = 3; i < N + 3; i++) {
            prefixSum[i] = prefixSum[i - 1] + (attend[i] ? 0 : 1);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            System.out.println(prefixSum[E] - prefixSum[S-1]);
        }
    }
}
