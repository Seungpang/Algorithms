package BJ;
// 사탕

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class No11256 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int candies = Integer.parseInt(st.nextToken());
            int numberOfBox = Integer.parseInt(st.nextToken());

            Integer[] count = new Integer[numberOfBox];
            for (int i = 0; i < numberOfBox; i++) {
                st = new StringTokenizer(br.readLine());
                count[i] = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
            }

            Arrays.sort(count, Collections.reverseOrder());

            int ans = 0;
            for (int i = 0; i < numberOfBox; i++) {
                candies -= count[i];
                ans++;
                if (candies <= 0) {
                    System.out.println(ans);
                    break;
                }
            }
        }
    }
}
