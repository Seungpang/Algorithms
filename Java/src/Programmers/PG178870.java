package Programmers;
// 연속된 부분 수열의 합

import java.util.Arrays;

public class PG178870 {

    public static void main(String[] args) {
        final PG178870 pg178870 = new PG178870();
        System.out.println(Arrays.toString(pg178870.solution(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(pg178870.solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5)));
        System.out.println(Arrays.toString(pg178870.solution(new int[]{2, 2, 2, 2, 2, 4}, 6)));
    }

    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0;
        int right;
        int count = Integer.MAX_VALUE;
        int sum = 0;
        for (right = 0; right < sequence.length; right++) {
            sum += sequence[right];
            while (sum > k && left < right) {
                sum -= sequence[left++];
            }
            if (sum == k){
                if (count > right - left) {
                    count = right - left;
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }
        return answer;
    }
}
