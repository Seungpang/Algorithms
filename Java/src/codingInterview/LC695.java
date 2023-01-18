package codingInterview;

public class LC695 {

    public static void main(String[] args) {
        final LC695 lc695 = new LC695();
        System.out.println(lc695.maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        }));
    }

    boolean[][] visit;

    public int maxAreaOfIsland(int[][] grid) {
        visit = new boolean[grid.length][grid[0].length];

        int result = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                result = Math.max(result, dfs(grid, r, c));
            }
        }
        return result;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r <0 || r>= grid.length || c <0 || c>= grid[0].length || visit[r][c] || grid[r][c] == 0) {
            return 0;
        }
        visit[r][c] = true;
        return (1 + dfs(grid, r + 1, c) + dfs(grid, r - 1, c) + dfs(grid, r, c - 1) + dfs(grid, r, c + 1));
    }
}
