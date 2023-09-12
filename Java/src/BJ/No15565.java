package BJ;
// 귀여운 라이언

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15565 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dolls = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, count = 0, ans = Integer.MAX_VALUE;
        while (true) {
            if (count < K) {
                if (end == N) {
                    break;
                }
                if (dolls[end++] == 1) {
                    count++;
                }
            } else {
                ans = Math.min(ans, end - start);
                if (dolls[start++] == 1) count--;
            }

            if (end > N && count < K) {
                break;
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
