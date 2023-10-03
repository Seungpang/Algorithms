package BJ;
// 행복 유치원

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class No13164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] height = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        Integer[] diffHeight = new Integer[N - 1];
        for (int i = 0; i < N - 1; i++) {
            diffHeight[i] = height[i + 1] - height[i];
        }

        Arrays.sort(diffHeight, Comparator.reverseOrder());

        int sum = 0;
        for (int i=K-1; i<diffHeight.length; i++){
            sum += diffHeight[i];
        }

        System.out.println(sum);
    }
}
