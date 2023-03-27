package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PG159993 {
    int n, m, lx, ly;
    boolean[][] visited;
    int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m];

        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'L') {
                    lx = i;
                    ly = j;
                }
                if (maps[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        int leverDistance = bfs1(x, y, maps);
        visited = new boolean[n][m];
        int exitDistance = bfs2(lx, ly, maps);
        if (leverDistance == -1 || exitDistance == -1) {
            return -1;
        }
        return leverDistance + exitDistance;
    }

    private int bfs1(int x, int y, String[] maps) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0));

        while (!q.isEmpty()) {
            Node nowNode = q.poll();
            for (int[] dir : dirs) {
                int dx = nowNode.x + dir[0];
                int dy = nowNode.y + dir[1];
                if (dx < 0 || dx >= n || dy < 0 || dy >= m) {
                    continue;
                }
                if (maps[dx].charAt(dy) == 'X' || visited[dx][dy]) {
                    continue;
                }
                if (maps[dx].charAt(dy) == 'L') {
                    return nowNode.count + 1;
                }
                visited[dx][dy] = true;
                q.offer(new Node(dx, dy, nowNode.count + 1));
            }
        }
        return -1;
    }

    private int bfs2(int x, int y, String[] maps) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0));

        while (!q.isEmpty()) {
            Node nowNode = q.poll();
            for (int[] dir : dirs) {
                int dx = nowNode.x + dir[0];
                int dy = nowNode.y + dir[1];
                if (dx < 0 || dx >= n || dy < 0 || dy >= m) {
                    continue;
                }
                if (maps[dx].charAt(dy) == 'X' || visited[dx][dy]) {
                    continue;
                }
                if (maps[dx].charAt(dy) == 'E') {
                    return nowNode.count + 1;
                }
                visited[dx][dy] = true;
                q.offer(new Node(dx, dy, nowNode.count + 1));
            }
        }
        return -1;
    }

    static class Node {
        private int x;
        private int y;
        private int count;

        public Node(final int x, final int y, final int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        final PG159993 pg159993 = new PG159993();
        String[] a = {
                "SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"
        };
        System.out.println(pg159993.solution(a));
    }
}
