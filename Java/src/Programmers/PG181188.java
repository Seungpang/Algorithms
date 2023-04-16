package Programmers;
// 요격 시스템

import java.util.PriorityQueue;

public class PG181188 {

    public static void main(String[] args) {
        final PG181188 pg181188 = new PG181188();
        System.out.println(pg181188.solution(new int[][]{
                {4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}
        }));
    }

    public int solution(int[][] targets) {
        PriorityQueue<Turret> pq = new PriorityQueue<>();
        for (int i=0; i<targets.length; i++) {
            for (int j=0; j<2; j++) {
                pq.offer(new Turret(targets[i][0], targets[i][1]));
            }
        }

        int count = 0;
        while (!pq.isEmpty()) {
            Turret now = pq.poll();
            count++;
            while (pq.peek() != null && now.end > pq.peek().start) {
                pq.remove();
            }
        }
        return count;
    }

    static class Turret implements Comparable<Turret> {
        int start;
        int end;

        Turret(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Turret t) {
            if (this.end == t.end) {
                return this.start - t.start;
            }
            return this.end - t.end;
        }
    }
}
