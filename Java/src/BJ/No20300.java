package BJ;
// 서강근육맨

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No20300 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] machines = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            machines[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(machines);

        long M;
        if (N % 2 == 0) {
            M = 0;
            for (int i = 0; i < N / 2; i++) {
                M = Math.max(M, machines[i] + machines[N - 1 - i]);
            }
        } else {
            M = machines[N - 1];
            for (int i = 0; i < (N - 1) / 2; i++) {
                M = Math.max(M, machines[i] + machines[N - 2 - i]);
            }
        }

        System.out.println(M);
    }
}
