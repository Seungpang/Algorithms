package BJ;
//큐

import java.util.Scanner;

public class No10845 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int[] queue = new int[n];
        int begin = 0;
        int end = 0;
        while (n-- > 0) {
            String cmd = sc.next();
            if (cmd.equals("push")) {
                int num = Integer.parseInt(sc.next());
                queue[end++ ] = num;
            } else if (cmd.equals("front")) {
                if (begin == end) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue[begin]).append("\n");
                }
            } else if (cmd.equals("size")) {
                sb.append(end - begin).append("\n");
            } else if (cmd.equals("empty")) {
                if (begin == end) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            } else if (cmd.equals("pop")) {
                if (begin == end) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue[begin]).append("\n");
                    begin += 1;
                }
            } else if (cmd.equals("back")) {
                if (begin == end) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue[end-1]).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
