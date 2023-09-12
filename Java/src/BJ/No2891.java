package BJ;
// 카약과 강품

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2891 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        boolean[] brokenKayaks = new boolean[N+2];
        boolean[] spareKayaks = new boolean[N+2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            brokenKayaks[Integer.parseInt(st.nextToken())] = true;
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < R; i++) {
            spareKayaks[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 1; i <= N; i++) {
            if (brokenKayaks[i]) {
                if (spareKayaks[i]) {
                    brokenKayaks[i] = false;
                    spareKayaks[i] = false;
                    S--;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (brokenKayaks[i]) {
                if (spareKayaks[i - 1]) {
                    brokenKayaks[i] = false;
                    spareKayaks[i - 1] = false;
                    S--;
                } else if (spareKayaks[i + 1]) {
                    brokenKayaks[i] = false;
                    spareKayaks[i + 1] = false;
                    S--;
                }
            }
        }
        System.out.println(S);
    }
}
