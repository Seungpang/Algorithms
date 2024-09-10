package BJ;
// 경쟁적 전염

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No18405 {

    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        PriorityQueue<Virus> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    pq.offer(new Virus(map[i][j], i, j, 0));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()) - 1;
        int Y = Integer.parseInt(st.nextToken()) - 1;


        while (!pq.isEmpty()) {
            final Virus now = pq.poll();
            if (now.time == S) break;

            for (int[] dir : dirs) {
                int nx = now.x + dir[0];
                int ny = now.y + dir[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 0) {
                    map[nx][ny] = now.type;
                    pq.offer(new Virus(now.type, nx, ny, now.time + 1));
                }
            }
        }

        System.out.println(map[X][Y]);
    }

    static class Virus implements Comparable<Virus> {
        int type, x, y, time;

        Virus(int type, int x, int y, int time) {
            this.type = type;
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Virus other) {
            if (this.time != other.time) return this.time - other.time;
            return this.type - other.type;
        }
    }
}
