package BJ;

import java.util.*;

public class No11000 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<ClassRoom> classRooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int startTime = sc.nextInt();
            int endTime = sc.nextInt();
            classRooms.add(new ClassRoom(startTime, endTime));
        }

        Collections.sort(classRooms);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty() && pq.peek() <= classRooms.get(i).startTime) {
                pq.poll();
            }
            pq.offer(classRooms.get(i).endTime);
            max = Math.max(max, pq.size());
        }
        System.out.println(max);
    }

    static class ClassRoom implements Comparable<ClassRoom> {
        int startTime, endTime;

        public ClassRoom(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(ClassRoom o) {
            if (this.startTime == o.startTime) {
                return this.endTime - o.endTime;
            }
            return this.startTime - o.startTime;
        }
    }
}
