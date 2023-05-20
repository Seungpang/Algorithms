package BJ;
// 암벽등반

import java.util.*;

public class No2412 {
    static int n, t;
    static List<Integer>[] a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        a = new ArrayList[200001];
        for (int i = 0; i < 200001; i++) {
            a[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            a[y].add(x);
        }

        for (int i = 0; i < 200001; i++) {
            Collections.sort(a[i]);
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));

        int move = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Node now = q.poll();
                if (now.y == t) return move;
                for (int y = now.y - 2; y <= now.y + 2; y++) {
                    if (y < 0 || y > 200001) {
                        continue;
                    }
                    for (int j = 0; j < a[y].size(); j++) {
                        int x = a[y].get(j);
                        if (now.x + 2 < x) {
                            break;
                        } else if (now.x - 2 > x) {
                            continue;
                        }
                        a[y].remove(j);
                        q.add(new Node(x, y));
                        j--;
                    }
                }
            }
            move++;
        }
        return -1;
    }

    static class Node {

        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
