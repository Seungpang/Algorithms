package BJ;
// 같이 눈사람 만들래?

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No20366 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] snowballs = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snowballs[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snowballs);

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i + 3; j < N; j++) {
                int left = i + 1;
                int right = j - 1;

                while (left < right) {
                    int sum1 = snowballs[i] + snowballs[j];
                    int sum2 = snowballs[left] + snowballs[right];
                    int diff = sum1 - sum2;

                    result = Math.min(result, Math.abs(diff));

                    if (diff < 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
