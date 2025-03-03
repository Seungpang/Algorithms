package BJ;
// 결전의 금요일

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No25194 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[] possible = new boolean[7];
        possible[0] = true;

        for (int i = 0; i < N; i++) {
            int duration = Integer.parseInt(st.nextToken());
            boolean[] newPossible = Arrays.copyOf(possible, 7);

            for (int j = 0; j < 7; j++) {
                if (possible[j]) {
                    int endDay = (j + duration) % 7;
                    newPossible[endDay] = true;
                }
            }

            possible = newPossible;
        }

        System.out.println(possible[4] ? "YES" : "NO");
    }
}
