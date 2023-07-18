package BJ;
// 녹색 옷 입은 애가 젤다지?

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No4485 {

    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            int[][] map = new int[N][N];
            int[][] dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            PriorityQueue<Point> pq = new PriorityQueue<>();
            pq.offer(new Point(0, 0, map[0][0]));
            dist[0][0] = map[0][0];
            while (!pq.isEmpty()) {
                Point now = pq.poll();
                for (int[] dir : dirs) {
                    int nx = now.x + dir[0];
                    int ny = now.y + dir[1];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                        if (dist[nx][ny] > dist[now.x][now.y] + map[nx][ny]) {
                            dist[nx][ny] = dist[now.x][now.y] + map[nx][ny];
                            pq.offer(new Point(nx, ny, dist[nx][ny]));
                        }
                    }
                }
            }
            System.out.println("Problem " + testCase + ": " + dist[N-1][N-1]);
            testCase++;
        }
    }

    static class Point implements Comparable<Point> {
        int x, y, cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost;
        }
    }
}
