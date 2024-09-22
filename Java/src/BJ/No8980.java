package BJ;
//택배

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class No8980 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        int M = sc.nextInt();

        List<Box> boxes = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            boxes.add(new Box(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(boxes);

        int[] capacity = new int[N + 1];
        int result = 0;

        for (Box box : boxes) {
            int maxLoad = C;
            for (int i = box.from; i < box.to; i++) {
                maxLoad = Math.min(maxLoad, C - capacity[i]);
            }

            int load = Math.min(maxLoad, box.quantity);
            if (load > 0) {
                result += load;
                for (int i = box.from; i < box.to; i++) {
                    capacity[i] += load;
                }
            }
        }

        System.out.println(result);
    }

    static class Box implements Comparable<Box> {

        int from,to,quantity;

        public Box(final int from, final int to, final int quantity) {
            this.from = from;
            this.to = to;
            this.quantity = quantity;
        }

        @Override
        public int compareTo(Box o) {
            if (this.to != o.to) {
                return this.to - o.to;
            }
            return o.from - this.from;
        }
    }
}
