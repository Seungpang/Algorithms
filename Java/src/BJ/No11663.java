package BJ;
// 선분 위의 점

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No11663 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] stones = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(stones);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            int leftIdx = binarySearch(stones, L);
            int rightIdx = binarySearch(stones, R + 1);
            int result = rightIdx - leftIdx;
            System.out.println(result);
        }
    }

     static int binarySearch(int[] stones, int target) {
        int left = 0;
        int right = stones.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (stones[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
