package BJ;
// 피로도

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No22864 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int ans = 0;
        int fatigue = 0;
        for (int i = 0; i < 24; i++) {
            if (fatigue + A <= M) {
                fatigue += A;
                ans += B;
            } else {
                fatigue = Math.max(fatigue - C, 0);
            }
        }

        System.out.println(ans);
    }
}
