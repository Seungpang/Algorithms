package BJ;
// 모양 만들기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class No16932 {

    static int N, M;
    static int[][] map;
    static int[][] group;
    static int[] groupSize;
    static int groupCount = 0;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        group = new int[N][M];
        groupSize = new int[N * M + 1];  // 최대 가능한 그룹 수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 그룹 식별 및 크기 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && group[i][j] == 0) {
                    groupCount++;
                    groupSize[groupCount] = dfs(i, j, groupCount);
                }
            }
        }

        // 0을 1로 바꾸며 최대 크기 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    calculateMaxSize(i, j);
                }
            }
        }

        System.out.println(max);
    }

    static int dfs(int x, int y, int groupId) {
        group[x][y] = groupId;
        int size = 1;

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 1 && group[nx][ny] == 0) {
                size += dfs(nx, ny, groupId);
            }
        }

        return size;
    }

    static void calculateMaxSize(int x, int y) {
        Set<Integer> adjacentGroups = new HashSet<>();
        int size = 1;  // 현재 0을 1로 바꾸는 것 포함

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 1) {
                int groupId = group[nx][ny];
                if (!adjacentGroups.contains(groupId)) {
                    size += groupSize[groupId];
                    adjacentGroups.add(groupId);
                }
            }
        }

        max = Math.max(max, size);
    }
}
