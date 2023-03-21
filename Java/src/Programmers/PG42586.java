package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PG42586 {

    public static void main(String[] args) {
        final PG42586 pg42586 = new PG42586();
        System.out.println(
                Arrays.toString(pg42586.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<progresses.length; i++) {
            q.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }

        List<Integer> answer = new ArrayList<>();
        while (!q.isEmpty()) {
            int day = q.poll();
            int cnt = 1;

            while (!q.isEmpty() && day >= q.peek()) {
                cnt++;
                q.poll();
            }
            answer.add(cnt);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
