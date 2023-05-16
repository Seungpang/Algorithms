package BJ;
// 강의실

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1374 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<ClassRoom> classRooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            classRooms.add(new ClassRoom(number, startTime, endTime));
        }

        Collections.sort(classRooms);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && q.peek() <= classRooms.get(i).startTime) {
                q.poll();
            }
            q.offer(classRooms.get(i).endTime);
            max = Math.max(max, q.size());
        }
        System.out.println(max);
    }

    static class ClassRoom implements Comparable<ClassRoom> {
        int number;
        int startTime;
        int endTime;

        public ClassRoom(int number, int startTime, int endTime) {
            this.number = number;
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
