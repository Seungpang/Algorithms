package Programmers;
// 구명보트

import java.util.Arrays;

public class PG42885 {

    public static void main(String[] args) {
        final PG42885 pg42885 = new PG42885();
        System.out.println(pg42885.solution(new int[]{70, 50, 80, 50}, 100));
    }

    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            answer++;
            right--;
        }
        return answer;
    }
}
