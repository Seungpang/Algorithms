package BJ;
// 백조의 호수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No3197 {

    static int R, C;
    static char[][] lake;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Queue<int[]> water = new LinkedList<>();
    static Queue<int[]> swan = new LinkedList<>();
    static boolean[][] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        lake = new char[R][C];
        visited = new boolean[R][C];
        parent = new int[R * C];

        int swan1 = -1, swan2 = -1;
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                lake[i][j] = line.charAt(j);
                if (lake[i][j] != 'X') {
                    water.offer(new int[]{i, j});
                }
                if (lake[i][j] == 'L') {
                    if (swan1 == -1) {
                        swan1 = i * C + j;
                    } else {
                        swan2 = i * C + j;
                    }
                    swan.offer(new int[]{i, j});
                }

                parent[i * C + j] = i * C + j;
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (lake[i][j] != 'X') {
                    for (int[] dir : dirs) {
                        int nx = i + dir[0];
                        int ny = j + dir[1];
                        if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                        if (lake[nx][ny] != 'X') {
                            union(i * C + j, nx * C + ny);
                        }
                    }
                }
            }
        }

        int days = 0;
        while (find(swan1) != find(swan2)) {
            meltIce();
            days++;
        }

        System.out.println(days);
    }

    static void meltIce() {
        int n = water.size();
        Queue<int[]> next = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int[] now = water.poll();
            int nowIdx = now[0] * C + now[1];
            for (int[] dir : dirs) {
                int nx = now[0] + dir[0];
                int ny = now[1] + dir[1];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                int nextIdx = nx * C + ny;
                if (lake[nx][ny] == 'X') {
                    lake[nx][ny] = '.';
                    next.offer(new int[]{nx, ny});
                    union(nowIdx, nextIdx);
                    for (int[] d : dirs) {
                        int nnx = nx + d[0];
                        int nny = ny + d[1];
                        if (nnx < 0 || nny < 0 || nnx >= R || nny >= C) continue;
                        if (lake[nnx][nny] == '.') {
                            union(nextIdx, nnx * C + nny);
                        }
                    }
                } else {
                    union(nowIdx, nextIdx);
                }
            }
        }
        water.addAll(next);
    }

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }
}
