package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PG42587 {

    public static void main(String[] args) {
        final PG42587 pg42587 = new PG42587();
        System.out.println(pg42587.solution(new int[]{2, 1, 3, 2}, 2));
    }

    public int solution(int[] priorities, int location) {
        Queue<Priorities> q = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            boolean target = i == location;
            q.add(new Priorities(priorities[i], target));
        }

        int answer = 0;
        int idx = 0;
        while (!q.isEmpty()) {
            Priorities now = q.poll();

            boolean isPossible = false;
            for (Priorities p : q) {
                if (now.value < p.value) {
                    isPossible = true;
                    break;
                }
            }

            if (isPossible) {
                q.add(now);
                continue;
            }

            idx++;
            if (now.target) {
                answer = idx;
            }
        }
        return answer;
    }

    static class Priorities {

        int value;
        boolean target;

        public Priorities(int value, boolean target) {
            this.value = value;
            this.target = target;
        }
    }
}
