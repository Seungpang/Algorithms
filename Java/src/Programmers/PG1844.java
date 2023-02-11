package Programmers;
//게임 맵 최단거리

import java.util.LinkedList;
import java.util.Queue;

public class PG1844 {
    public static void main(String[] args) {
        final PG1844 pg1844 = new PG1844();
        System.out.println(pg1844.solution(new int[][]{
                {1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}
        }));
    }
    boolean[][] visited;
    int[][] dirs = {{0,-1},{0, 1}, {-1,0}, {1,0}};
    int n;
    int m;

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        return bfs(maps, 0, 0);
    }

    private int bfs(int[][] maps, int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y,1));

        while (!q.isEmpty()) {
            Node nowNode = q.poll();
            if (nowNode.x == n-1 && nowNode.y == m-1) {
                return nowNode.cost;
            }

            for (int[] dir : dirs) {
                int dx = nowNode.x + dir[0];
                int dy = nowNode.y + dir[1];
                if (dx >= 0 && dy >= 0 && dx < n && dy <m) {
                    if (maps[dx][dy] == 1 && !visited[dx][dy]) {
                        visited[dx][dy] = true;
                        q.offer(new Node(dx, dy, nowNode.cost + 1));
                    }
                }
            }
        }
        return -1;
    }

    class Node {
        private int x;
        private int y;
        private int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost =cost;
        }
    }
}
