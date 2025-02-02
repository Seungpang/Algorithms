package BJ;
//캐슬 디펜스

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class No17135 {

    static int N, M, D, answer;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;
        comb(0, 0, new int[3]);
        System.out.println(answer);
    }

    static void comb(int start, int cnt, int[] pos) {
        if (cnt == 3) {
            answer = Math.max(answer, simulate(pos));
            return;
        }

        for (int i = start; i < M; i++) {
            pos[cnt] = i;
            comb(i + 1, cnt + 1, pos);
        }
    }

    static int simulate(int[] archers) {
        int killCount = 0;
        int[][] simMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            simMap[i] = Arrays.copyOf(map[i], M);
        }

        for (int round = 0; round < N; round++) {
            Set<Point> targets = new HashSet<>();

            for (int archer : archers) {
                Point target = findTarget(simMap, archer);
                if (target != null) {
                    targets.add(target);
                }
            }

            for (Point p : targets) {
                if (simMap[p.r][p.c] == 1) {
                    simMap[p.r][p.c] = 0;
                    killCount++;
                }
            }

            simMap = moveEnemies(simMap);
        }

        return killCount;
    }

    static Point findTarget(int[][] simMap, int archerCol) {
        Point target = null;
        int minDist = Integer.MAX_VALUE;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (simMap[r][c] == 1) {
                    int dist = Math.abs(N - r) + Math.abs(archerCol - c);
                    if (dist <= D) {
                        if (dist < minDist) {
                            minDist = dist;
                            target = new Point(r, c);
                        } else if (dist == minDist && target != null && c < target.c) {
                            target = new Point(r, c);
                        }
                    }
                }
            }
        }

        return target;
    }

    static int[][] moveEnemies(int[][] simMap) {
        int[][] newMap = new int[N][M];
        for (int r = N - 2; r >= 0; r--) {
            newMap[r + 1] = Arrays.copyOf(simMap[r], M);
        }
        newMap[0] = new int[M];
        return newMap;
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(final Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Point point = (Point)o;
            return r == point.r && c == point.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }
}
