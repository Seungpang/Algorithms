package BJ;
// 구슬 탈출

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No13459 {
    static class Point {
        int rx;
        int ry;
        int bx;
        int by;
        int count;

        public Point(int rx, int ry) {
            this.rx = rx;
            this.ry = ry;
        }

        public Point(int rx, int ry, int bx, int by, int count) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.count = count;
        }
    }

    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        Point red = null;
        Point blue = null;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'R') {
                    red = new Point(i, j);
                } else if (map[i][j] == 'B') {
                    blue = new Point(i, j);
                }
            }
        }

        System.out.println(bfs(red.rx, red.ry, blue.rx, blue.ry));
    }

    private static int bfs(int rx, int ry, int bx, int by) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(rx, ry, bx, by, 1));
        visited[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.count > 10) {
                return 0;
            }
            for (int i = 0; i < 4; i++) {
                int nrx = p.rx;
                int nry = p.ry;
                int nbx = p.bx;
                int nby = p.by;

                while (true) {
                    nrx += dx[i];
                    nry += dy[i];

                    if (map[nrx][nry] == 'O') {
                        break;
                    }
                    if (map[nrx][nry] == '#') {
                        nrx -= dx[i];
                        nry -= dy[i];
                        break;
                    }
                }

                while (true) {
                    nbx += dx[i];
                    nby += dy[i];

                    if (map[nbx][nby] == 'O') {
                        break;
                    }
                    if (map[nbx][nby] == '#') {
                        nbx -= dx[i];
                        nby -= dy[i];
                        break;
                    }
                }

                if (map[nbx][nby] == 'O') {
                    continue;
                }
                if (map[nrx][nry] == 'O') {
                    return 1;
                }

                //빨간 구슬과 파란 구슬의 위치가 같으면 방향에 따라 한칸 이전으로 돌린다.
                if (nrx == nbx && nry == nby) {
                    switch (i) {
                        case 0:
                            if (p.rx > p.bx) nrx++;
                            else nbx++;
                            break;
                        case 1:
                            if (p.ry > p.by) nry++;
                            else nby++;
                            break;
                        case 2:
                            if (p.rx > p.bx) nbx--;
                            else nrx--;
                            break;
                        case 3:
                            if (p.ry > p.by) nby--;
                            else nry--;
                    }
                }

                //방문하지 않았으면 큐에 추가하고 방문처리한다.
                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    q.add(new Point(nrx, nry, nbx, nby, p.count + 1));
                }
            }
        }
        return 0;
    }
}
