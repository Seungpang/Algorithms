package BJ;
// Zigzag

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15779 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 2;
        int len = 2;
        for (int i = 0; i < n - 2; i++) {
            if (arr[i] <= arr[i + 1] && arr[i + 1] <= arr[i + 2]) {
                len = 2;
            } else if (arr[i] >= arr[i + 1] && arr[i + 1] >= arr[i + 2]) {
                len = 2;
            } else {
                len++;
            }
            max = Math.max(len, max);
        }
        System.out.println(max);
    }
}
