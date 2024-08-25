package BJ;
// 마법사 상어와 블리자드

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No21611 {

    static int N, M;
    static int[][] map;
    static int[] d, s;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};
    static int res;
    static int[][] xy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        d = new int[M];
        s = new int[M];
        xy = new int[N * N][2];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            d[i] = Integer.parseInt(st.nextToken());
            s[i] = Integer.parseInt(st.nextToken());
        }
        setxy();

        simulation();
        System.out.println(res);
    }

    private static void setxy() {
        int x = N / 2, y = N / 2;
        int nx, ny;
        int curDir = 3;
        int dist = 1;
        int num = 1;

        while (true) {
            for (int k = 0; k < 2; k++) {
                for (int i = 0; i < dist; i++) {
                    if (x == 0 && y == 0) return;
                    nx = x + dx[curDir];
                    ny = y + dy[curDir];
                    xy[num][0] = nx;
                    xy[num][1] = ny;
                    num++;
                    x = nx;
                    y = ny;
                }
                curDir = curDir == 1 ? 3 : curDir == 2 ? 4 : curDir == 3 ? 2 : 1;
            }
            dist++;
        }
    }

    private static void simulation() {
        for (int time = 0; time < M; time++) {
            breakMarbles(d[time], s[time]);
            do {
                moveMarbles();
            } while (explodeMarbles());
            changeMarbles();
        }
    }

    private static void breakMarbles(int dir, int distance) {
        int nx = N / 2, ny = N / 2;
        for (int i = 0; i < distance; i++) {
            nx += dx[dir];
            ny += dy[dir];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;
            map[nx][ny] = 0;
        }
    }

    private static void moveMarbles() {
        for (int i = 1; i < N * N; i++) {
            int cx = xy[i][0];
            int cy = xy[i][1];
            if (map[cx][cy] == 0) {
                for (int j = i + 1; j < N * N; j++) {
                    int nx = xy[j][0];
                    int ny = xy[j][1];
                    if (map[nx][ny] != 0) {
                        map[cx][cy] = map[nx][ny];
                        map[nx][ny] = 0;
                        break;
                    }
                }
            }
        }
    }

    private static boolean explodeMarbles() {
        boolean exploded = false;
        List<int[]> sameMarbles = new ArrayList<>();
        int count = 1;
        int prev = 0;

        for (int i = 1; i < N * N; i++) {
            int cx = xy[i][0];
            int cy = xy[i][1];
            int current = map[cx][cy];

            if (current == 0) break;

            if (current == prev) {
                count++;
                sameMarbles.add(new int[]{cx, cy});
            } else {
                if (count >= 4) {
                    exploded = true;
                    for (int[] pos : sameMarbles) {
                        res += map[pos[0]][pos[1]];
                        map[pos[0]][pos[1]] = 0;
                    }
                }
                count = 1;
                sameMarbles.clear();
                sameMarbles.add(new int[]{cx, cy});
            }
            prev = current;
        }

        if (count >= 4) {
            exploded = true;
            for (int[] pos : sameMarbles) {
                res += map[pos[0]][pos[1]];
                map[pos[0]][pos[1]] = 0;
            }
        }

        return exploded;
    }

    private static void changeMarbles() {
        int[][] newMap = new int[N][N];
        int count = 1;
        int prev = 0;
        int idx = 1;

        for (int i = 1; i < N * N; i++) {
            int cx = xy[i][0];
            int cy = xy[i][1];
            int current = map[cx][cy];

            if (current == 0) break;

            if (current == prev) {
                count++;
            } else {
                if (prev != 0) {
                    if (idx < N * N) {
                        newMap[xy[idx][0]][xy[idx][1]] = count;
                        idx++;
                    }
                    if (idx < N * N) {
                        newMap[xy[idx][0]][xy[idx][1]] = prev;
                        idx++;
                    }
                }
                count = 1;
            }
            prev = current;
        }

        if (prev != 0 && idx < N * N) {
            newMap[xy[idx][0]][xy[idx][1]] = count;
            idx++;
            if (idx < N * N) {
                newMap[xy[idx][0]][xy[idx][1]] = prev;
            }
        }

        map = newMap;
    }
}
