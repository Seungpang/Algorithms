package BJ;
// 팩토리얼 0의 개수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11687 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        int left = 1, right = 2000000000;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (countZero(mid) >= M) {
                if (countZero(mid) == M) {
                    result = mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }

    static int countZero(int num) {
        int count = 0;
        for (long i = 5; num / i >= 1; i *= 5) {
            count += num / i;
        }
        return count;
    }
}
