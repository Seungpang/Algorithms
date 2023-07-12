package BJ;
// 겹치는 건 싫어

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No20922 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] checked = new int[100001];
        int left = 0;
        int right = 0;
        int max = 0;
        while (left <= right && right < N) {
            if (checked[arr[right]] >= K) {
                checked[arr[left]]--;
                left++;
            } else {
                checked[arr[right]]++;
                right++;
            }
            max = Math.max(max, right - left);

        }
        System.out.println(max);
    }
}
