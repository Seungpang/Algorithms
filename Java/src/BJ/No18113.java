package BJ;
//그르다 김가놈

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No18113 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> kimbap = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int kb = Integer.parseInt(br.readLine());
            if (kb > (2 * K)) {
                kimbap.add(kb - (2 * K));
            } else if (2 * K > kb && kb > K) {
                kimbap.add(kb - K);
            }
        }

        int left = 0;
        int right = 1000000000;
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid == 0) {
                left++;
                continue;
            }
            if (cutKimbap(mid, kimbap) >= M) {
                result = Math.max(result, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }

    static int cutKimbap(int length, List<Integer> kimbap) {
        int result = 0;
        for (int i : kimbap) {
            result += (i / length);
        }
        return result;
    }
}
