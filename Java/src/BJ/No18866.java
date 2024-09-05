package BJ;
// 젊은 날의 생이여

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No18866 {

    static class Day {
        int happy, sleepy;
        Day(int happy, int sleepy) {
            this.happy = happy;
            this.sleepy = sleepy;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Day[] days = new Day[N + 1];
        Day[] youth = new Day[N + 1];
        Day[] old = new Day[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            days[i] = new Day(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        calculateYouthDays(N, days, youth);
        calculateOldDays(N, days, old);

        int result = findMaxYoungDays(N, youth, old);
        System.out.println(result);
    }

    private static void calculateYouthDays(int N, Day[] days, Day[] youth) {
        int minHappy = Integer.MAX_VALUE, maxSleepy = -1;
        for (int i = 1; i <= N; i++) {
            if (days[i].happy != 0) minHappy = Math.min(minHappy, days[i].happy);
            if (days[i].sleepy != 0) maxSleepy = Math.max(maxSleepy, days[i].sleepy);
            youth[i] = new Day(minHappy, maxSleepy);
        }
    }

    private static void calculateOldDays(int N, Day[] days, Day[] old) {
        int maxHappy = -1, minSleepy = Integer.MAX_VALUE;
        for (int i = N; i >= 1; i--) {
            if (days[i].happy != 0) maxHappy = Math.max(maxHappy, days[i].happy);
            if (days[i].sleepy != 0) minSleepy = Math.min(minSleepy, days[i].sleepy);
            old[i] = new Day(maxHappy, minSleepy);
        }
    }

    private static int findMaxYoungDays(int N, Day[] youth, Day[] old) {
        for (int k = N - 1; k >= 1; k--) {
            if (youth[k].happy > old[k+1].happy && youth[k].sleepy < old[k+1].sleepy) {
                return k;
            }
        }
        return -1;
    }
}
