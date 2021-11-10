package BJ;
//힙
//가운데를 말해요

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No1655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (left.isEmpty() || right.isEmpty()) { //힙이 비어있으면 추가
                left.add(x);
            } else {
                if (x <= left.peek()) {
                    left.add(x);
                } else if (x >= right.peek()) {
                    right.add(x);
                } else {
                    left.add(x);
                }
            }
            while (!(left.size() == right.size() || left.size() == right.size() + 1)) {
                if (left.size() > right.size()) {
                    right.add(left.peek());
                    left.poll();
                } else {
                    left.add(right.peek());
                    right.poll();
                }
            }
            bw.write(left.peek() + "\n");
        }
        bw.flush();
    }
}
