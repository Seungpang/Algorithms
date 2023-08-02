package BJ;
// 개업

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No13910 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] wokSizes = new int[M];

        st = new StringTokenizer(br.readLine());
        List<Integer> possibleSizes = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            wokSizes[i] = Integer.parseInt(st.nextToken());
            possibleSizes.add(wokSizes[i]);
        }

        for (int i = 0; i < M; i++) {
            for (int j = i+1; j < M; j++) {
                int size = wokSizes[i] + wokSizes[j];
                if (size <= N) {
                    possibleSizes.add(size);
                }
            }
        }

        Collections.sort(possibleSizes);
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int size : possibleSizes) {
                if (i < size) {
                    break;
                } else if (i == size) {
                    dp[i] = 1;
                    break;
                } else if (dp[i - size] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - size] + 1);
                }
            }
        }

        if (dp[N] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }
    }
}
