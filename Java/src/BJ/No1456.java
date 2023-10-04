package BJ;
// 거의 소수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1456 {
    static final int MAX = 10000001; // 10^7
    static long[] decimal = new long[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        for (int i = 2; i < MAX; ++i) { // 배열 초기화
            decimal[i] = i;
        }

        for (int i = 2; i * i < MAX; ++i) { // 에라토스테네스의 체로 소수 구하기
            if (decimal[i] == 0)
                continue;
            for (int j = i + i; j < MAX; j += i)
                decimal[j] = 0;
        }

        int cnt = 0;
        for (int i = 2; i < MAX; i++) {
            if (decimal[i] != 0) {
                long temp = decimal[i];
                while ((double) temp <= (double) B / (double) decimal[i]) {
                    if ((double) temp >= (double) A / (double) decimal[i])
                        cnt++;
                    temp *= decimal[i];
                }
            }
        }

        System.out.println(cnt);
    }
}

