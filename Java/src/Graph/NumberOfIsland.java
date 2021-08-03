package Graph;

public class NumberOfIsland {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','0','1'},
                {'1','1','0','0','0'},
                {'1','1','0','0','1'},
                {'0','0','0','0','1'}
        };
        NumberOfIsland a = new NumberOfIsland();
        System.out.println(a.solution(grid));
    }

    int m, n;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    int count;
    public int solution(char[][] grid) {
        print(grid);
        //1 에러처리
        if( grid==null || grid.length==0 || grid[0].length==0) return 0;

        m = grid.length;
        n = grid[0].length;

        //2 00위치가 1인 것부터 찾기
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    //System.out.print(" grid["+i+"]["+j+"] " +grid[i][j]);
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j){

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') {
            return;
        }
        grid[i][j]='X';

        for (int[] dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1]);
        }

    }

    public void print(char[][] grid) {
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid.length; j++){
                System.out.println(" grid["+i+"]["+j+"] " +grid[i][j]);
            }
        }
    }
}
