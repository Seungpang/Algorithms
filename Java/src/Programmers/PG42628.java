package Programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class PG42628 {

    public static void main(String[] args) {
        final PG42628 pg42628 = new PG42628();
        System.out.println(Arrays.toString(
                pg42628.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
        System.out.println(Arrays.toString(
                pg42628.solution(new String[]{"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"})));

    }

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> frontpq = new PriorityQueue<>();
        PriorityQueue<Integer> backpq = new PriorityQueue<>(Collections.reverseOrder());

        int insertCount = 0;
        int deleteCount = 0;
        for (int i=0; i<operations.length; i++) {
            String[] command = operations[i].split(" ");
            if (command[0].equals("I")) {
                if (insertCount == deleteCount) {
                    frontpq = new PriorityQueue<>();
                    backpq = new PriorityQueue<>(Collections.reverseOrder());
                }
                frontpq.add(Integer.parseInt(command[1]));
                backpq.add(Integer.parseInt(command[1]));
                insertCount++;
            } else {
                if (!frontpq.isEmpty() && command[1].equals("-1")) {
                    frontpq.poll();
                    deleteCount++;
                } else if (!backpq.isEmpty() && command[1].equals("1")) {
                    backpq.poll();
                    deleteCount++;
                }
            }
        }
        if (insertCount <= deleteCount) {
            return new int[]{0, 0};
        }
        return new int[]{backpq.poll(), frontpq.poll()};
    }
}
