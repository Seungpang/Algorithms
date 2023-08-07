package BJ;
// 0의 개수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11170 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int count = 0;
            for (int i = N; i <= M; i++) {
                String num = String.valueOf(i);
                for (int j = 0; j < num.length(); j++) {
                    if (num.charAt(j) == '0') {
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
