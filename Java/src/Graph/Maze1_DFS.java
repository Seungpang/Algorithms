package Graph;

public class Maze1_DFS {
    public static void main(String[] args) {
        int[][] maze={
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };
        int[] start = {0,4};
        int[] dest = {4,4};

        Maze1_DFS a = new Maze1_DFS();
        System.out.println(a.hasPath(maze, start, dest));
    }

    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    int m,n;
    public boolean hasPath(int[][] maze, int[] start, int[] dest){
        if(maze==null||maze.length==0)
            return false;
        m = maze.length;
        n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(maze, start, dest, visited);
    }

    public boolean dfs(int[][] maze, int[] start, int dest[], boolean[][] visited){
        if(start[0] < 0 || start[0] >=m || start[1] < 0 || start[1] >=n || visited[start[0]][start[1]])
            return false;

        visited[start[0]][start[1]]=true;
        if(start[0]==dest[0] && start[1]==dest[1]) return true;

        for(int[] dir : dirs){
            int x = start[0];
            int y = start[1];
            while (x>=0 && x <m && y>=0 && y <n && maze[x][y]!=1){
                x += dir[0];
                y += dir[1];
            }
            x -= dir[0];
            y -= dir[1];
            if(dfs(maze, new int[] {x, y}, dest, visited))
                return true;
        }

        return false;
    }
}
