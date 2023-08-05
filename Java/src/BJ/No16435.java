package BJ;
// 스네이크 버드

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No16435 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] bugs = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            bugs[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(bugs);

        for (int bug : bugs) {
            if (bug <= L) {
                L++;
            }
        }

        System.out.println(L);
    }
}
