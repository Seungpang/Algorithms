package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No1943 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < 3; t++) {
            int N = Integer.parseInt(br.readLine());
            int totalAmount = 0;
            List<int[]> coins = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int value = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                totalAmount += value * count;
                coins.add(new int[]{value, count});
            }

            if (totalAmount % 2 != 0) {
                sb.append("0\n");
                continue;
            }

            int target = totalAmount / 2;
            boolean[] dp = new boolean[target + 1];
            dp[0] = true;

            for (int[] coin : coins) {
                int value = coin[0];
                int count = coin[1];

                for (int i = target; i >= value; i--) {
                    if (dp[i - value]) {
                        for (int j = 0; j < count && i + j * value <= target; j++) {
                            dp[i + j * value] = true;
                        }
                    }
                }
            }

            sb.append(dp[target] ? "1\n" : "0\n");
        }

        System.out.print(sb);
    }
}
