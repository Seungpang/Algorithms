package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No20117 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] quantity = new int[N];
        for (int i = 0; i < N; i++) {
            quantity[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(quantity);

        int answer = 0;
        int left = 0;
        int right = N - 1;

        while (left < right) {
            answer += quantity[right] * 2;
            left++;
            right--;
        }

        if (left == right) {
            answer += quantity[left];
        }

        System.out.println(answer);
    }
}
