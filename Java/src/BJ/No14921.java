package BJ;
// 용액 합성하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No14921 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N-1;
        int ans = Integer.MAX_VALUE;
        while (left < right) {
            int mid = arr[left] + arr[right];
            if (Math.abs(ans) > Math.abs(mid)) {
                ans = mid;
            }
            if (mid > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(ans);
    }
}
