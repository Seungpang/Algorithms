package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland_BFS {

    public static void main(String[] args) {

        char[][] grid = {
            {'1', '1', '0', '0', '1'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
            {'1', '0', '0', '1', '1'}
        };

        NumberOfIsland_BFS a = new NumberOfIsland_BFS();
        System.out.println(a.numberOfIsland(grid));
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;

    int numberOfIsland(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;

        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int x, int y) {
        grid[x][y] = 'X';
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            for (int[] dir : dirs) {
                int dx = point[0] + dir[0];
                int dy = point[1] + dir[1];
                if (dx >= 0 && dx < m && dy >= 0 && dy < n && grid[dx][dy] == '1') {
                    grid[dx][dy] = '0';
                    queue.offer(new int[]{dx, dy});
                }
            }
        }
    }

}

