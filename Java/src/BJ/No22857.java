package BJ;
// 가장 긴 짝수 연속한 부분 수열 (small)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No22857 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] a = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int count = 0;
        int result = 0;
        while (end < N) {
            if (count < K || a[end] % 2 == 0) {
                if (a[end] % 2 != 0) {
                    count++;
                }
                end++;
                result = Math.max(result, end - start - count);
            } else {
                if (a[start] % 2 != 0) {
                    count--;
                }
                start++;
            }
        }
        System.out.println(result);
    }
}
