package Programmers;

import java.util.Arrays;

public class PG43236 {

    public static void main(String[] args) {
        final PG43236 pg43236 = new PG43236();
        System.out.println(pg43236.solution(25, new int[]{2, 14, 11, 21, 17}, 2));
    }

    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int start = 0;
        int end = distance;
        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = 0;
            int prev = 0;
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid) {
                    cnt++;
                } else {
                    prev = rocks[i];
                }
            }
            if (distance - prev < mid) {
                cnt++;
            }
            if (cnt <= n) {
                answer = Math.max(mid, answer);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return answer;
    }
}
