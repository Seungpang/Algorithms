package BJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

//최솟값 찾기
public class No11003 {

    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(stringTokenizer.nextToken());
        final int l = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(br.readLine());
        final Deque<Node> mydeque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(stringTokenizer.nextToken());

            while (!mydeque.isEmpty() && mydeque.getLast().value > now) {
                mydeque.removeLast();
            }
            mydeque.addLast(new Node(now, i));

            if (mydeque.getFirst().index <= i - l) {
                mydeque.removeFirst();
            }
            bw.write(mydeque.getFirst().value+ " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node {
        public final int value;
        public final int index;

        public Node(final int value, final int index) {
            this.value = value;
            this.index = index;
        }
    }
}
