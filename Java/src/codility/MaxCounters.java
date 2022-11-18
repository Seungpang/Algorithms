package codility;

import java.util.Arrays;

public class MaxCounters {

    public static void main(String[] args) {
        final MaxCounters maxCounters = new MaxCounters();
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        System.out.println(Arrays.toString(maxCounters.solution(5, A)));
    }

    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int[] counters = new int[N];
        int maxCounter = 0;
        int lastMaxCounter = 0;

        for (int i=0; i<A.length; i++) {
            if (A[i] >= 1 && A[i] <= N) {
                int counterNum = A[i] - 1;
                if (counters[counterNum] < lastMaxCounter) {
                    counters[counterNum] = lastMaxCounter + 1;
                } else {
                    counters[counterNum]++;
                }
                maxCounter = Math.max(maxCounter, counters[counterNum]);
            } else {
                lastMaxCounter = maxCounter;
            }
        }

        for (int i = 0; i < N; i++) {
            if (counters[i] < lastMaxCounter) {
                counters[i] = lastMaxCounter;
            }
        }

        return counters;
    }
}
