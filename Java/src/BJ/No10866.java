package BJ;
//덱

import java.util.Scanner;

public class No10866 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int[] deque = new int[n * 2];
        int begin = n;
        int end = n;
        int size = 0;
        while (n-- > 0) {
            String cmd = sc.next();
            if (cmd.equals("push_front")) {
                int num = Integer.parseInt(sc.next());
                deque[begin--] = num;
                size++;
            } else if (cmd.equals("push_back")) {
                int num = Integer.parseInt(sc.next());
                size++;
                deque[++end] = num;
            } else if (cmd.equals("pop_front")) {
                if (size == 0) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(deque[begin+1]).append("\n");
                    begin++;
                    size--;
                }
            } else if (cmd.equals("pop_back")) {
                if (size == 0) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(deque[end]).append("\n");
                    end--;
                    size--;
                }
            }
            else if (cmd.equals("size")) {
                sb.append(size).append("\n");
            } else if (cmd.equals("empty")) {
                if (size == 0) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            } else if (cmd.equals("front")) {
                if (begin == end) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(deque[begin+1]).append("\n");
                }
            } else if (cmd.equals("back")) {
                if (begin == end) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(deque[end]).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
