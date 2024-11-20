package BJ;
// 다리 만들기 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class No17472 {

    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int N, M, islandCount;
    static int[][] map;
    static boolean[][] visited;
    static List<Edge> edges = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 찾아서 번호 매기기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    islandCount++;
                    bfs(i, j, islandCount + 1);
                }
            }
        }

        // 다리 후보 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 1) {
                    int startIsland = map[i][j];
                    for (int d = 0; d < 4; d++) {
                        buildBridge(i, j, d, startIsland);
                    }
                }
            }
        }

        // 최소 스패닝 트리
        parent = new int[islandCount + 2];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        Collections.sort(edges);

        int result = 0;
        int useEdge = 0;
        for (Edge edge : edges) {
            if (find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                result += edge.value;
                useEdge++;
            }
        }

        if (useEdge == islandCount - 1) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    static void bfs(int i, int j, int num) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        map[i][j] = num;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    map[nx][ny] = num;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    static void buildBridge(int x, int y, int dir, int startIsland) {
        int length = 0;
        int nx = x;
        int ny = y;

        while (true) {
            nx += dirs[dir][0];
            ny += dirs[dir][1];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) return;
            if (map[nx][ny] == startIsland) return;
            if (map[nx][ny] > 1 && map[nx][ny] != startIsland) {
                if (length >= 2) {
                    edges.add(new Edge(startIsland, map[nx][ny], length));
                }
                return;
            }

            if (map[nx][ny] == 0) {
                length++;
            } else {
                return;
            }
        }
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    static class Edge implements Comparable<Edge> {
        int start, end, value;

        public Edge(final int start, final int end, final int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(final Edge o) {
            return this.value - o.value;
        }
    }
}
