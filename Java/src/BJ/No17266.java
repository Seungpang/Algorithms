package BJ;
// 어두운 굴다리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No17266 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] lamps = new int[M];
        for (int i = 0; i < M; i++) {
            lamps[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lamps);

        int maxGap = Math.max(lamps[0], N - lamps[M - 1]);
        for (int i = 1; i < M; i++) {
            maxGap = Math.max(maxGap, (lamps[i] - lamps[i - 1] + 1) / 2);
        }

        System.out.println(maxGap);
    }
}
