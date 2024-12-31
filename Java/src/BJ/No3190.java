package BJ;
// 뱀

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class No3190 {

    static int N, K, L;
    static boolean[][] map;
    static Map<Integer, Character> directions = new HashMap<>();
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new boolean[N][N];
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            map[row][col] = true;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            directions.put(X, C);
        }


        System.out.println(go());
    }

    static int go() {
        Deque<Point> snake = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        snake.offer(new Point(0, 0));
        visited[0][0] = true;

        int time = 0;
        int direction = 0;
        while (true) {
            time++;

            Point head = snake.peekLast();
            int nx = head.row + dirs[direction][0];
            int ny = head.col + dirs[direction][1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                return time;
            }

            snake.offer(new Point(nx, ny));
            visited[nx][ny] = true;

            if (map[nx][ny]) {
                map[nx][ny] = false;
            } else {
                Point tail = snake.poll();
                visited[tail.row][tail.col] = false;
            }

            if (directions.containsKey(time)) {
                char turn = directions.get(time);
                if (turn == 'L') {
                    direction = (direction + 3) % 4;
                } else if (turn == 'D') {
                    direction = (direction + 1) % 4;
                }
            }
        }
    }

    static class Point {
        int row, col;

        public Point(final int row, final int col) {
            this.row = row;
            this.col = col;
        }
    }
}
