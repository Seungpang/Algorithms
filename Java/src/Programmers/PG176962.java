package Programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

// 과제 진행하기
public class PG176962 {

    public static void main(String[] args) {
        final PG176962 pg176962 = new PG176962();
        System.out.println(Arrays.toString(pg176962.solution(new String[][]{
                {"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}
        })));

        System.out.println(Arrays.toString(pg176962.solution(new String[][]{
                {"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}
        })));

        System.out.println(Arrays.toString(pg176962.solution(new String[][]{
                {"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}
        })));
    }

    public String[] solution(String[][] plans) {
        PriorityQueue<Plan> pq = new PriorityQueue<>();
        Stack<Plan> stopPlans = new Stack<>();
        for (int i = 0; i < plans.length; i++) {
            pq.offer(new Plan(plans[i][0], plans[i][1], plans[i][2]));
        }

        List<String> result = new ArrayList<>();
        int currTime = pq.peek().start;
        stopPlans.push(pq.poll());
        while (!pq.isEmpty()) {
            Plan next;
            if (pq.peek().start < currTime + stopPlans.peek().playtime) {
                next = pq.poll();
                stopPlans.peek().playtime -= next.start - currTime;
                currTime = next.start;
                stopPlans.push(next);
            } else {
                currTime += stopPlans.peek().playtime;
                result.add(stopPlans.pop().name);
            }
            if (stopPlans.isEmpty()) {
                currTime = pq.peek().start;
                stopPlans.push(pq.poll());
            }
        }
        while (!stopPlans.isEmpty()) {
            result.add(stopPlans.pop().name);
        }

        return result.toArray(new String[0]);
    }
    static class Plan implements Comparable<Plan> {
        String name;
        int start;
        int playtime;

        public Plan(String name, String start, String playtime) {
            this.name = name;
            this.start = convertTime(start);
            this.playtime = Integer.parseInt(playtime);
        }
        private int convertTime(String time) {
            String[] times = time.split(":");
            return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
        }

        @Override
        public int compareTo(final Plan o) {
            return this.start - o.start;
        }
    }
}
