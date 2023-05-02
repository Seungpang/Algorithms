package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No17406 {
    static int n,m, k;
    static int[][] board, cycle;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cycle = new int[k][3];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            cycle[i][0] = Integer.parseInt(st.nextToken()) - 1;
            cycle[i][1] = Integer.parseInt(st.nextToken()) - 1;
            cycle[i][2] = Integer.parseInt(st.nextToken());
        }

        permutation(0, new int[k], new boolean[k]);

        System.out.printf("%d", min);
    }

    public static void permutation(int count, int[] arr, boolean[] visited) {
        if (count == k) {
            runCycle(arr);
            return;
        }
        for (int i = 0; i < k; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            arr[count] = i;
            permutation(count + 1, arr, visited);
            visited[i] = false;
        }
    }

    public static void runCycle(int[] arr) {
        int[][] temp = copyBoard();

        for (int z = 0; z < k; z++) {
            int r = cycle[arr[z]][0];
            int c = cycle[arr[z]][1];
            int i = cycle[arr[z]][2];

            for (int s = 1; s <= i; s++) {
                //위
                int upTmp = temp[r-s][c+s];
                for(int y = c+i; y > c-i; y--) {
                    temp[r-s][y] = temp[r-s][y-1];
                }
                //오른쪽
                int rightTmp = temp[r+s][c+s];
                for(int x = r+s; x > r-s; x--) {
                    temp[x][c+s] = temp[x-1][c+s];
                }
                temp[r-s+1][c+s] = upTmp;
                //아래
                int leftTmp = temp[r+s][c-s];
                for(int y = c-s; y < c+s; y++) {
                    temp[r+s][y] = temp[r+s][y+1];
                }
                temp[r+s][c+s-1] = rightTmp;
                //왼쪽
                for(int x = r-s; x < r+s; x++) {
                    temp[x][c-s] = temp[x+1][c-s];
                }
                temp[r+s-1][c-s] = leftTmp;
            }
        }
        calculateMinValue(temp);
    }

    public static int[][] copyBoard() {
        int[][] temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = board[i][j];
            }
        }
        return temp;
    }

    private static void calculateMinValue(int[][] a) {
        for (int i = 0; i < n; i++) {
            min = Math.min(min, Arrays.stream(a[i]).sum());
        }
    }
}
