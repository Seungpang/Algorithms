package BJ;
// 휴게소 세우기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1477 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] positions = new int[N + 2];
        positions[0] = 0;
        positions[N + 1] = L;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            positions[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(positions);

        int left = 1;
        int right = L;
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;

            for (int i = 1; i < positions.length; i++) {
                int distance = positions[i] - positions[i - 1];
                if (distance > mid) {
                    count += (distance - 1) / mid;
                }
            }

            if (count > M) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
