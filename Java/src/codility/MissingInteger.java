package codility;

import java.util.Arrays;

public class MissingInteger {

    public static void main(String[] args) {
        final MissingInteger missingInteger = new MissingInteger();
        System.out.println(missingInteger.solution(new int[]{1, 6, 4, 1, 2})); //3
        System.out.println(missingInteger.solution(new int[]{1, 2, 3})); //4
        System.out.println(missingInteger.solution(new int[]{-1, -3})); //1
        System.out.println(missingInteger.solution(new int[]{-1, 5, 8, 4, 2, 3, 4, 8, 9, 100, 234, 525, 333, 526})); //1
    }

    public int solution(int[] A) {
        Arrays.sort(A);
        int min = 1;
        for (int num : A) {
            if (num == min) {
                min += 1;
            }
        }

        return min;
    }
}
