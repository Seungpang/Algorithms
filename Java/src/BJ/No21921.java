package BJ;
// 블로그

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No21921 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sums = new int[N - X + 1];
        int windowSum = 0;
        for (int i = 0; i < X; i++) {
            windowSum += arr[i];
        }
        sums[0] = windowSum;

        for (int i = X; i < N; i++) {
            windowSum = windowSum - arr[i - X] + arr[i];
            sums[i - X + 1] = windowSum;
        }

        int max = 0;
        int count = 0;
        for (int sum : sums) {
            if (sum > max) {
                max = sum;
                count = 1;
            } else if (sum == max) {
                count++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(max);
        System.out.println(count);
    }
}
