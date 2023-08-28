package BJ;
// 2+1 세일

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class No11508 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] dairyProducts = new Integer[N];
        for (int i = 0; i < N; i++) {
            dairyProducts[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(dairyProducts, Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (i % 3 == 2) {
                continue;
            }
            sum += dairyProducts[i];
        }

        System.out.println(sum);
    }
}
