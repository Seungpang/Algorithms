package BJ;
// 스타트링크

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No5014 {

    private static final int MAX = 1000001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt();
        int s = sc.nextInt();
        int g = sc.nextInt();
        int u = sc.nextInt();
        int d = sc.nextInt();

        Queue<Elevator> q = new LinkedList<>();
        boolean[] visited = new boolean[MAX];
        q.add(new Elevator(s, 0));
        visited[s] = true;
        int result = -1;
        while (!q.isEmpty()) {
            Elevator now = q.poll();
            if (now.floor == g) {
                result = now.count;
            }
            if (now.floor + u <= f && !visited[now.floor + u]) {
                visited[now.floor + u] = true;
                q.add(new Elevator(now.floor + u, now.count + 1));
            }
            if (now.floor - d >= 1 && !visited[now.floor - d]) {
                visited[now.floor - d] = true;
                q.add(new Elevator(now.floor - d, now.count + 1));
            }
        }
        if (result == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(result);
        }
    }

    static class Elevator {
        int floor;
        int count;

        public Elevator(final int floor, final int count) {
            this.floor = floor;
            this.count = count;
        }
    }
}
