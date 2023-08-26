package BJ;
// 아기 상어 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No17086 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dy = {0, 1, 0 ,-1 , -1 , 1 , -1 , 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxDistance=0;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==0){
                    maxDistance=Math.max(maxDistance,bfs(i,j));
                }
            }
        }

        System.out.println(maxDistance);

    }

    public static int bfs(int x,int y){
        Queue<int[]> queue=new LinkedList<>();
        visited=new boolean[N][M];

        queue.offer(new int[]{x,y});
        visited[x][y]=true;

        int distance=-1;

        while(!queue.isEmpty()){
            distance++;

            for(int k=queue.size();k>0;k--){
                x=queue.peek()[0];
                y=queue.peek()[1];
                queue.poll();

                if(map[x][y]==1){
                    return distance;
                }

                for (int i = 0; i <8 ; ++i) {
                    int nx=x+dx[i],ny=y+dy[i];

                    if(nx>=N || ny>=M || nx<0 || ny<0 || visited[nx][ny]) continue;

                    queue.offer(new int[]{nx,ny});
                    visited[nx][ny]=true;

                }
            }
        }

        return distance;
    }
}
