package BJ;
// 스마트택시

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class No19238 {

    static int N, M;
    static int fuel;
    static int[][] map;
    static int taxiRow, taxiCol;
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static Map<Integer, Passenger> passengers = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        taxiRow = Integer.parseInt(st.nextToken()) - 1;
        taxiCol = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startRow = Integer.parseInt(st.nextToken()) - 1;
            int startCol = Integer.parseInt(st.nextToken()) - 1;
            int endRow = Integer.parseInt(st.nextToken()) - 1;
            int endCol = Integer.parseInt(st.nextToken()) - 1;
            passengers.put(startRow * N + startCol, new Passenger(startRow, startCol, endRow, endCol));
        }

        for (int i = 0; i < M; i++) {
            int[] result = findNearestPassenger(taxiRow, taxiCol);
            int passengerRow = result[0];
            int passengerCol = result[1];
            int distToPassenger = result[2];

            if (passengerRow == -1 || passengerCol == -1 || fuel < distToPassenger) {
                System.out.println(-1);
                return;
            }

            taxiRow = passengerRow;
            taxiCol = passengerCol;
            fuel -= distToPassenger;

            Passenger p = passengers.remove(passengerRow * N + passengerCol);
            int distToEnd = bfs(taxiRow, taxiCol, p.endRow, p.endCol);
            if (distToEnd == -1 || fuel < distToEnd) {
                System.out.println(-1);
                return;
            }

            taxiRow = p.endRow;
            taxiCol = p.endCol;
            fuel -= distToEnd;
            fuel += distToEnd * 2;
        }

        System.out.println(fuel);
    }

    static int[] findNearestPassenger(int startRow, int startCol) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int[][] dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }

        q.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;
        dist[startRow][startCol] = 0;

        int minDist = Integer.MAX_VALUE;
        List<int[]> candidates = new ArrayList<>();

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            if (dist[r][c] > minDist) break;

            if (passengers.containsKey(r * N + c)) {
                if (dist[r][c] < minDist) {
                    minDist = dist[r][c];
                    candidates.clear();
                    candidates.add(new int[]{r, c});
                } else if (dist[r][c] == minDist) {
                    candidates.add(new int[]{r, c});
                }
            }

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (!visited[nr][nc] && map[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    dist[nr][nc] = dist[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        if (candidates.isEmpty()) {
            return new int[]{-1, -1, 0};
        }

        candidates.sort((o1, o2) -> {
            if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o1[0], o2[0]);
        });

        int nr = candidates.get(0)[0];
        int nc = candidates.get(0)[1];
        return new int[]{nr, nc, dist[nr][nc]};
    }

    static int bfs(int startR, int startC, int endR, int endC) {
        if (startR == endR && startC == endC) return 0;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        queue.offer(new int[]{startR, startC});
        visited[startR][startC] = true;

        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];

                if (r == endR && c == endC) {
                    return distance;
                }

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    if (!visited[nr][nc] && map[nr][nc] == 0) {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
            distance++;
        }

        return -1;
    }

    static class Passenger {
        int startRow, startCol, endRow, endCol;

        public Passenger(final int startRow, final int startCol, final int endRow, final int endCol) {
            this.startRow = startRow;
            this.startCol = startCol;
            this.endRow = endRow;
            this.endCol = endCol;
        }
    }
}
