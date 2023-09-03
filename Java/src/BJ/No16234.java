package BJ;
//시뮬레이션 구현
//인구 이동

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No16234 {

    final static int[] dx = {0, 0, -1, 1};
    final static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        while (true) {
            if (bfs(A, L, R)) {
                ans += 1;
            } else {
                break;
            }
        }
        System.out.println(ans);
    }

    static boolean bfs(int[][] A, int L, int R) {
        int n = A.length;
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }

        boolean isMoved = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    Queue<int[]> s = new LinkedList<>();
                    s.add(new int[]{i, j});
                    int sum = A[i][j];
                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        int x = now[0];
                        int y = now[1];
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                                if (visited[nx][ny]) continue;
                                int diff = A[nx][ny] - A[x][y];
                                if (diff < 0) diff = -diff;
                                if (L <= diff && diff <= R) {
                                    q.add(new int[]{nx, ny});
                                    s.add(new int[]{nx, ny});
                                    visited[nx][ny] = true;
                                    isMoved = true;
                                    sum += A[nx][ny];
                                }
                            }
                        }
                    }
                    int val = sum / s.size();
                    while (!s.isEmpty()) {
                        int[] now = s.poll();
                        int x = now[0];
                        int y = now[1];
                        A[x][y] = val;
                    }
                }
            }
        }
        return isMoved;
    }
}
