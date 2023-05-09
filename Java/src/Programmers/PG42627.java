package Programmers;

import java.util.PriorityQueue;

public class PG42627 {

    public static void main(String[] args) {
        final PG42627 pg42627 = new PG42627();
        System.out.println(pg42627.solution(new int[][]{
                {0, 3}, {1, 9}, {2, 6}
        }));

        System.out.println(pg42627.solution(new int[][]{
                {0, 3}, {10, 11}
        }));
    }

    public int solution(int[][] jobs) {
        PriorityQueue<Disk> pq = new PriorityQueue<>();

        pq.offer(new Disk(jobs[0][0], jobs[0][1]));
        int end = pq.peek().end;
        int result = 0;
        int idx = 1;
        while (!pq.isEmpty()) {
            Disk now = pq.poll();
            end += now.end;
            result += end - now.start;
            while (idx < jobs.length && jobs[idx][1] <= end) {
                pq.offer(new Disk(jobs[idx][0], jobs[idx][1]));
                idx++;
            }

            if (idx < jobs.length && pq.isEmpty()) {
                end = jobs[idx][0];
                pq.offer(new Disk(jobs[idx][0], jobs[idx][1]));
                idx++;
            }

        }
        return result / jobs.length;
    }

    static class Disk implements Comparable<Disk> {
        int start, end;

        public Disk(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Disk d) {
            if (this.end - d.end == 0) {
                return this.start - d.start;
            }
            return this.end - d.end;
        }
    }
}
