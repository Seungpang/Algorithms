package BJ;
// 평행 우주

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17451 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long result = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (result < arr[i]) {
                result = arr[i];
            } else if (arr[i] < result && result % arr[i] != 0) {
                result = ((result / arr[i]) + 1) * arr[i];
            }
        }

        System.out.println(result);
    }
}
