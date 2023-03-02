package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PG159993 {
    int n,m,lx,ly;
    boolean[][] visited;
    int[][] dirs = {{0,-1}, {0,1}, {-1,0}, {1,0}};

    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m];

        int x = 0;
        int y = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
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
        int answer = bfs(0, 0, maps);
        return answer == 0 ? -1 : bfs(0,0, maps) + 1;
    }

    private int bfs(int x, int y, String[] maps) {
        int count = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));

        while (!q.isEmpty()) {
            Node nowNode = q.poll();
            for (int[] dir : dirs) {
                int dx = nowNode.x + dir[0];
                int dy = nowNode.y + dir[1];
                if (dx >=0 && dy >=0 && dx < n && dy < m) {
                    if ((maps[dx].charAt(dy) == 'O' || maps[dx].charAt(dy) == 'L') && !visited[dx][dy]) {
                        visited[dx][dy] = true;
                        count++;
                        q.offer(new Node(dx, dy));
                        System.out.println("통로: " + count);
                    }
                    if (maps[dx].charAt(dy) == 'E' && !visited[dx][dy] && visited[lx][ly]) {
                        System.out.println("E  " + count);
                        break;
                    }
                }
            }
        }
        return count;
    }

    static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
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
