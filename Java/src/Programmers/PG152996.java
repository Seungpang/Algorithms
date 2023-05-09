package Programmers;

import java.util.Arrays;

public class PG152996 {

    public static void main(String[] args) {
        PG152996 pg152996 = new PG152996();
        System.out.println(pg152996.solution(new int[]{
                100,180,360,100,270
        }));
    }

    public long solution(int[] weights) {
        long[] weightsCount = new long[4001];
        long count = 0;
        Arrays.sort(weights);
        for (int weight : weights) {
            if (weightsCount[weight] == 0) {
                weightsCount[weight] = 1;
            } else {
                count += weightsCount[weight];
                weightsCount[weight] += 1;
            }
        }

        long[] result = new long[4001];
        for (int i=2; i<5; i++) {
            for (int weight : weights) {
                int temp = weight * i;
                System.out.println(temp);
                if (result[temp] == 0) {
                    result[temp] = weightsCount[weight];
                } else {
                    //System.out.println(result[temp] * weightsCount[weight]);
                    count += result[temp] * weightsCount[weight];
                    result[temp] += weightsCount[weight];
                }
            }
        }
        return count;
    }
}
