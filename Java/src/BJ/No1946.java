package BJ;
// 신입사원

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class No1946 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] scores = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                scores[i][0] = Integer.parseInt(st.nextToken());
                scores[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(scores, Comparator.comparingInt(a -> a[0]));

            int count = 1;
            int minInterviewRank = scores[0][1];

            for (int i = 1; i < N; i++) {
                if (scores[i][1] < minInterviewRank) {
                    count++;
                    minInterviewRank = scores[i][1];
                }
            }

            sb.append(count).append('\n');
        }

        System.out.println(sb);
    }
}
